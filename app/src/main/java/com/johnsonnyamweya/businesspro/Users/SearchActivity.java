package com.johnsonnyamweya.businesspro.Users;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsonnyamweya.businesspro.Models.Products;
import com.johnsonnyamweya.businesspro.Models.ProductsViewHolder;
import com.johnsonnyamweya.businesspro.R;
import com.squareup.picasso.Picasso;

public class SearchActivity extends AppCompatActivity {

    private EditText searchInput;
    private Button searchButton;
    private RecyclerView searchRecyclerview;
    String searchInputString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchInput = findViewById(R.id.search_product_name);
        searchButton = findViewById(R.id.search_btn);
        searchRecyclerview = findViewById(R.id.search_recyclerview);

        searchRecyclerview.setLayoutManager(new LinearLayoutManager(SearchActivity.this));

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchInputString = searchInput.getText().toString().toLowerCase();

                onStart();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        DatabaseReference productRef = FirebaseDatabase.getInstance().getReference().child("Products");

        FirebaseRecyclerOptions<Products> options = new FirebaseRecyclerOptions.Builder<Products>()
                .setQuery(productRef.orderByChild("pName")
                        .startAt(searchInputString), Products.class)
                .build();

        FirebaseRecyclerAdapter<Products, ProductsViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ProductsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ProductsViewHolder holder,
                                            int position, @NonNull Products model) {

                holder.txtProductName.setText(model.getpName());
                holder.txtProductDescription.setText(model.getDescription());
                holder.txtProductPrice.setText("Price = KShs " + model.getPrice());
                Picasso.get().load(model.getImage()).into(holder.productImage);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(SearchActivity.this, ProductDetailsActivity.class);
                        intent.putExtra("pid", model.getPid());
                        startActivity(intent);
                    }
                });

            }

            @NonNull
            @Override
            public ProductsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.products_viewholder_layout, parent, false);

                ProductsViewHolder holder = new ProductsViewHolder(view);
                return holder;
            }
        };

        searchRecyclerview.setAdapter(adapter);
        adapter.startListening();

    }
}