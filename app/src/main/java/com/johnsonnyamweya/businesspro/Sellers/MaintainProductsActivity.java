package com.johnsonnyamweya.businesspro.Sellers;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.johnsonnyamweya.businesspro.R;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Objects;

public class MaintainProductsActivity extends AppCompatActivity {

    private EditText name, price, description;
    private ImageView imageView;

    private String productID = "";
    private DatabaseReference productsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_products);

        productID = getIntent().getExtras().get("pid").toString();

        productsRef = FirebaseDatabase.getInstance().getReference().child("Products").child(productID);

        Button applyChangesBtn = findViewById(R.id.apply_changes_btn);
        Button deleteBtn = findViewById(R.id.delete_product_btn);
        name = findViewById(R.id.product_name_maintain);
        description = findViewById(R.id.product_description_maintain);
        price = findViewById(R.id.product_price_maintain);
        imageView = findViewById(R.id.product_image_maintain);

        displaySpecificProductInfo();

        applyChangesBtn.setOnClickListener(view -> applyChanges());

        deleteBtn.setOnClickListener(view -> deleteProduct());

    }

    private void applyChanges() {

        String productName = name.getText().toString();
        String productPrice = price.getText().toString();
        String productDescription = description.getText().toString();

        if (TextUtils.isEmpty(productName)){
            Toast.makeText(this, "Please write product name", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(productDescription)){

            Toast.makeText(this, "Please write product description", Toast.LENGTH_SHORT).show();
        }
        else if(TextUtils.isEmpty(productPrice)){
            Toast.makeText(this, "Please write product price" , Toast.LENGTH_SHORT).show();
        }

        else{

            HashMap<String, Object> maintainMap = new HashMap<>();

            maintainMap.put("pid", productID);
            maintainMap.put("pName", productName);
            maintainMap.put("price", productPrice);
            maintainMap.put("description", productDescription);

            productsRef.updateChildren(maintainMap).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(MaintainProductsActivity.this,
                            "Applied changes successfully", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MaintainProductsActivity.this,
                            SellerHomeActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    finish();


                }
            });

        }

    }

    private void deleteProduct() {

        productsRef.removeValue().addOnCompleteListener(task -> {
            if (task.isSuccessful()){
                Intent intent = new Intent(MaintainProductsActivity.this,
                        SellerHomeActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();

                Toast.makeText(MaintainProductsActivity.this,
                        "Product deleted successfully", Toast.LENGTH_SHORT).show();

            }

            else {
                Objects.requireNonNull(task.getException()).getMessage();
            }

        });

    }

    private void displaySpecificProductInfo() {

        productsRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if (snapshot.exists()){
                    String pName = Objects.requireNonNull(snapshot.child("pName").getValue()).toString();
                    String pDescription = Objects.requireNonNull(snapshot.child("description").getValue()).toString();
                    String pPrice = Objects.requireNonNull(snapshot.child("price").getValue()).toString();
                    String pImage = Objects.requireNonNull(snapshot.child("image").getValue()).toString();

                    name.setText(pName);
                    description.setText(pDescription);
                    price.setText(pPrice);
                    Picasso.get().load(pImage).into(imageView);

                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}