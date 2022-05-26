package com.johnsonnyamweya.businesspro.Users;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsonnyamweya.businesspro.Models.Cart;
import com.johnsonnyamweya.businesspro.Models.CartViewHolder;
import com.johnsonnyamweya.businesspro.R;

public class CartActivity extends AppCompatActivity {

    private RecyclerView cartRecyclerview;
    RecyclerView.LayoutManager layoutManager;

    private Button nextProcessButton;
    private TextView txtTotalAmount, txtMessage1;
    private int overTotalPrice = 0;

    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        mAuth = FirebaseAuth.getInstance();

        cartRecyclerview = findViewById(R.id.cart_list_rv);
        layoutManager = new LinearLayoutManager(this);
        cartRecyclerview.setHasFixedSize(true);
        cartRecyclerview.setLayoutManager(layoutManager);

        nextProcessButton = (Button) findViewById(R.id.next_process_button);

        txtTotalAmount = (TextView) findViewById(R.id.total_price);
        txtMessage1 = (TextView) findViewById(R.id.msg1);

        nextProcessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtTotalAmount.setText("Total price = KShs" + String.valueOf(overTotalPrice));

                Intent intent = new Intent(CartActivity.this, ConfirmFinalOrderActivity.class);
                intent.putExtra("Total Price", String.valueOf(overTotalPrice));
                startActivity(intent);
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        final DatabaseReference cartListRef = FirebaseDatabase.getInstance()
                .getReference().child("Cart List");

        FirebaseRecyclerOptions<Cart> options = new FirebaseRecyclerOptions.Builder<Cart>()
                .setQuery(cartListRef.child("User View")
                        .child(mAuth.getCurrentUser().getUid()).child("Products"), Cart.class)
                .build();

        FirebaseRecyclerAdapter<Cart, CartViewHolder> adapter =
                new FirebaseRecyclerAdapter<Cart, CartViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull CartViewHolder holder, int position, @NonNull Cart model) {
                        holder.txtProductQuantity.setText("Quantity = " + model.getQuantity());
                        holder.txtProductPrice.setText("Price = KShs" + model.getPrice());
                        holder.txtProductName.setText(model.getpName());

                        //int oneTypeProductTPrice = ((Integer.valueOf(model.getPrice()) * Integer.valueOf(model.getQuantity())));
                        int price = Integer.parseInt(model.getPrice());
                        int quantity = Integer.parseInt(model.getQuantity());
                         int oneTypeProductTPrice = price * quantity;
                        overTotalPrice = overTotalPrice + oneTypeProductTPrice;

                        holder.itemView.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                CharSequence options[] = new CharSequence[]{
                                        "Edit",
                                        "Remove"
                                };

                                AlertDialog.Builder builder = new AlertDialog.Builder(CartActivity.this);

                                builder.setTitle("Cart Options");
                                builder.setItems(options, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int position) {
                                        if (position == 0){
                                            Intent intent = new Intent(CartActivity.this,
                                                    ProductDetailsActivity.class);
                                            intent.putExtra("pid", model.getPid());
                                            startActivity(intent);
                                        }

                                        if (position == 1){
                                            cartListRef.child(mAuth.getCurrentUser().getUid())
                                                    .child("Products").child(model.getPid()).removeValue()
                                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                                @Override
                                                public void onComplete(@NonNull Task<Void> task) {
                                                    if (task.isSuccessful()){
                                                        Toast.makeText(CartActivity.this
                                                                , "Item removed successfully", Toast.LENGTH_SHORT).show();
                                                        Intent intent = new Intent(CartActivity.this
                                                                , UserHomeActivity.class);
                                                        startActivity(intent);
                                                    }
                                                }
                                            });
                                        }
                                    }
                                });

                                builder.show();
                            }
                        });

                    }

                    @NonNull
                    @Override
                    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.cart_items_layout, parent, false);

                        CartViewHolder holder = new CartViewHolder(view);
                        return holder;
                    }
                };

        cartRecyclerview.setAdapter(adapter);
        adapter.startListening();

    }
}