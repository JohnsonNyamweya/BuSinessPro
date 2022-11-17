package com.johnsonnyamweya.businesspro.Users;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.johnsonnyamweya.businesspro.Models.Products;
import com.johnsonnyamweya.businesspro.R;
import com.squareup.picasso.Picasso;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class ProductDetailsActivity extends AppCompatActivity {

    private ImageView productImage;
    private TextView productName, productDescription, productPrice;
    private EditText productQuantity;

    String productID = "", state = "Normal";

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        mAuth = FirebaseAuth.getInstance();

        productID = getIntent().getStringExtra("pid");

        Button addToCartButton = findViewById(R.id.product_details_add_to_cart_button);
         productImage = findViewById(R.id.product_image_details);
         productName = findViewById(R.id.product_name_details);
         productDescription = findViewById(R.id.product_description_details);
         productPrice = findViewById(R.id.product_price_details);
         productQuantity = findViewById(R.id.product_quantity_details);

        getProductDetails(productID);

        addToCartButton.setOnClickListener(view -> {

            if (TextUtils.isEmpty(productQuantity.getText().toString())){
                Toast.makeText(ProductDetailsActivity.this,
                        "Please enter your quantity", Toast.LENGTH_SHORT).show();
            }
            else{
                //addToCartList();

                if (!state.equals("shipped") && state.equals("order placed")){
                    Toast.makeText(ProductDetailsActivity.this,
                            "You can purchase more products once your order is shipped or confirmed", Toast.LENGTH_LONG).show();
                }
                else {
                    addToCartList();
                }
            }


        });

    }

    private void addToCartList() {
        String saveCurrentTime, saveCurrentDate;

        Calendar calendar = Calendar.getInstance();

        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance()
                .getReference().child("Cart List");

        final HashMap<String, Object> cartMap = new HashMap<>();
        cartMap.put("pid", productID);
        cartMap.put("pName", productName.getText().toString());
        cartMap.put("price", productPrice.getText().toString());
        cartMap.put("description", productDescription.getText().toString());
        cartMap.put("date", saveCurrentDate);
        cartMap.put("time", saveCurrentTime);
        cartMap.put("quantity", productQuantity.getText().toString());

        cartListRef.child("User View").child(Objects.requireNonNull(mAuth.getCurrentUser()).getUid())
                .child("Products").child(productID).updateChildren(cartMap)
        .addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                cartListRef.child("Admin View").child(mAuth.getCurrentUser().getUid())
                        .child("Products").child(productID).updateChildren(cartMap)
                .addOnCompleteListener(task1 -> {
                    if (task1.isSuccessful()){
                        Toast.makeText(ProductDetailsActivity.this
                                , "Added to Cart List", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ProductDetailsActivity.this,
                                UserHomeActivity.class);
                        startActivity(intent);
                    }
                });
            }
        });

    }

    private void getProductDetails(String productID) {

        DatabaseReference productsRef = FirebaseDatabase.getInstance().getReference().child("Products");

        productsRef.child(productID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
//                    Return the instance of Products class populated with data.
                    Products products = snapshot.getValue(Products.class);

                    assert products != null;
                    productName.setText(products.getpName());
                    productDescription.setText(products.getDescription());
                    productPrice.setText(products.getPrice());
                    Picasso.get().load(products.getImage()).into(productImage);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        checkOrderState();
    }

    private void checkOrderState() {

        DatabaseReference ordersRef = FirebaseDatabase.getInstance().getReference()
                .child("Orders").child(Objects.requireNonNull(mAuth.getCurrentUser()).getUid());

        ordersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    String shippingState = Objects.requireNonNull(snapshot.child("state").getValue()).toString();

                    if (shippingState.equals("shipped")){
                        state = "order shipped";
                    }
                    if (shippingState.equals("not shipped")){
                        state = "order placed";
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}