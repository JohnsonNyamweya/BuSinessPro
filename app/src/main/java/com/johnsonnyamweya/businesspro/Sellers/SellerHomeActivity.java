package com.johnsonnyamweya.businesspro.Sellers;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsonnyamweya.businesspro.MainActivity;
import com.johnsonnyamweya.businesspro.Models.ItemViewHolder;
import com.johnsonnyamweya.businesspro.Models.Products;
import com.johnsonnyamweya.businesspro.R;
import com.squareup.picasso.Picasso;

public class SellerHomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private BottomNavigationView bottomNavigationView;
    private RecyclerView sellerProductsRecyclerview;
    RecyclerView.LayoutManager layoutManager;
    private DatabaseReference unverifiedProductsRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_home);


        unverifiedProductsRef = FirebaseDatabase.getInstance().getReference()
                .child("Products");

        mAuth = FirebaseAuth.getInstance();

        Toolbar toolbar = (Toolbar) findViewById(R.id.seller_toolbar);
        toolbar.setTitle("My Products");
        setSupportActionBar(toolbar);

        sellerProductsRecyclerview = findViewById(R.id.seller_products_rv);
        sellerProductsRecyclerview.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        sellerProductsRecyclerview.setLayoutManager(layoutManager);

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.nav_view);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_home:
                        Intent intentHome = new Intent(SellerHomeActivity.this,
                                SellerHomeActivity.class);
                        startActivity(intentHome);

                        return true;

                    case R.id.navigation_add:
                        Intent intentCategory = new Intent(SellerHomeActivity.this,
                                SellerProductsCategoryActivity.class);
                        startActivity(intentCategory);

                        return true;

                    case R.id.navigation_logout:

                        mAuth.signOut();

                        Intent intent_main = new Intent(SellerHomeActivity.this, MainActivity.class);
                        startActivity(intent_main);
                        return true;

                }

                return false;
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Products> options = new FirebaseRecyclerOptions.Builder<Products>()
                .setQuery(unverifiedProductsRef.orderByChild("sid")
                        .equalTo(FirebaseAuth.getInstance().getCurrentUser().getUid()), Products.class)
                .build();

        FirebaseRecyclerAdapter<Products, ItemViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ItemViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ItemViewHolder holder, int position, @NonNull Products model) {

                holder.txtProductName.setText(model.getpName());
                holder.txtProductStatus.setText("State : " + model.getProductState());
                holder.txtProductPrice.setText("Price = KShs " +model.getPrice());
                holder.txtProductDescription.setText(model.getDescription());

                Picasso.get().load(model.getImage()).into(holder.imageView);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Intent maintainProductsIntent =
                                new Intent(SellerHomeActivity.this, MaintainProductsActivity.class);
                        maintainProductsIntent.putExtra("pid", model.getPid());
                        startActivity(maintainProductsIntent);

                    }
                });

            }


            @NonNull
            @Override
            public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.seller_items, parent, false);
                ItemViewHolder holder = new ItemViewHolder(view);
                return holder;
            }
        };

        sellerProductsRecyclerview.setAdapter(adapter);
        adapter.startListening();

    }

}