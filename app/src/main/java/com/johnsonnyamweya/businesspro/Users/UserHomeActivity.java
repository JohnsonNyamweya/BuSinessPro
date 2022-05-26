package com.johnsonnyamweya.businesspro.Users;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsonnyamweya.businesspro.MainActivity;
import com.johnsonnyamweya.businesspro.Models.Products;
import com.johnsonnyamweya.businesspro.Models.ProductsViewHolder;
import com.johnsonnyamweya.businesspro.R;
import com.squareup.picasso.Picasso;

public class UserHomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DatabaseReference productReference;
    private FirebaseAuth mAuth;
    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        mAuth = FirebaseAuth.getInstance();
        productReference = FirebaseDatabase.getInstance().getReference().child("Products");

        recyclerView = findViewById(R.id.user_products_rv);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Category");
        setSupportActionBar(toolbar);

        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.user_refreshLayout);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(false);
            }
        });


        DrawerLayout drawerLayout = findViewById(R.id.user_drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                UserHomeActivity.this, drawerLayout, toolbar, R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.user_bottom_nav_view);

        NavigationView navigationView = findViewById(R.id.user_nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_user_home:

                        Intent intentHome = new Intent(UserHomeActivity.this, UserHomeActivity.class);
                        startActivity(intentHome);

                        return true;


                    case R.id.navigation_user_cart:

                        Intent cartIntent = new Intent(UserHomeActivity.this, CartActivity.class);
                        startActivity(cartIntent);

                        return true;

                    case R.id.navigation_user_search:

                        Intent userSearchIntent = new Intent(UserHomeActivity.this, SearchActivity.class);
                        startActivity(userSearchIntent);

                        return true;

                    case R.id.navigation_user_help:

                        Intent userHelpIntent = new Intent(UserHomeActivity.this, UserHelpActivity.class);
                        startActivity(userHelpIntent);

                        return true;

                    case R.id.navigation_user_logout:
                        mAuth.signOut();

                        Intent userMainIntent = new Intent(UserHomeActivity.this, MainActivity.class);
                        startActivity(userMainIntent);

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
                .setQuery(productReference.orderByChild("productState").equalTo("Approved"), Products.class)
                .build();

        final FirebaseRecyclerAdapter<Products, ProductsViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ProductsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull Products model) {

                holder.txtProductName.setText(model.getpName());
                holder.txtProductDescription.setText(model.getDescription());
                holder.txtProductPrice.setText("Price = KShs " + model.getPrice());
                Picasso.get().load(model.getImage()).into(holder.productImage);

                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent productDetailsIntent = new Intent(UserHomeActivity.this,
                                ProductDetailsActivity.class);
                        productDetailsIntent.putExtra("pid", model.getPid());
                        startActivity(productDetailsIntent);
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

        recyclerView.setAdapter(adapter);
        adapter.startListening();

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawerLayout = findViewById(R.id.user_drawer_layout);
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {


        return false;

//        DrawerLayout drawerLayout = findViewById(R.id.user_drawer_layout);
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
    }
}