package com.johnsonnyamweya.businesspro.CategoriesUnderUser;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsonnyamweya.businesspro.Models.Products;
import com.johnsonnyamweya.businesspro.Models.ProductsViewHolder;
import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Users.ProductDetailsActivity;
import com.squareup.picasso.Picasso;

public class CategoryOfGardenAndOutdoorsActivity extends AppCompatActivity {

    private DatabaseReference gardenAndOutdoorsReference;
    private RecyclerView categoryOfGardenAndOutdoorsRv;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_of_garden_and_outdoors);

        gardenAndOutdoorsReference = FirebaseDatabase.getInstance().getReference().child("Products");

        categoryOfGardenAndOutdoorsRv = findViewById(R.id.category_of_garden_and_outdoors_rv);
        categoryOfGardenAndOutdoorsRv.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        categoryOfGardenAndOutdoorsRv.setLayoutManager(layoutManager);

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Garden And Outdoors");
        setSupportActionBar(toolbar);

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<Products> options = new FirebaseRecyclerOptions.Builder<Products>()
                .setQuery(gardenAndOutdoorsReference.orderByChild("category").equalTo("Garden and Outdoors"), Products.class)
                .build();

        final FirebaseRecyclerAdapter<Products, ProductsViewHolder> adapter =
                new FirebaseRecyclerAdapter<Products, ProductsViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull ProductsViewHolder holder, int position, @NonNull Products model) {

                        holder.txtProductName.setText(model.getpName());
                        holder.txtProductDescription.setText(model.getDescription());
                        holder.txtProductPrice.setText("Price = KShs " + model.getPrice());
                        Picasso.get().load(model.getImage()).into(holder.productImage);

                        holder.itemView.setOnClickListener(view -> {
                            Intent productDetailsIntent = new Intent(CategoryOfGardenAndOutdoorsActivity.this,
                                    ProductDetailsActivity.class);
                            productDetailsIntent.putExtra("pid", model.getPid());
                            startActivity(productDetailsIntent);
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

        categoryOfGardenAndOutdoorsRv.setAdapter(adapter);
        adapter.startListening();

    }

}