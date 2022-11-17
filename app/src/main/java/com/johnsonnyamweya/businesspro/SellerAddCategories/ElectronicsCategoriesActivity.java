package com.johnsonnyamweya.businesspro.SellerAddCategories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;

public class ElectronicsCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_categories);

        TextView televisionAndVideo = findViewById(R.id.television_video);
        TextView homeAudio = findViewById(R.id.home_audio);
        TextView accessoriesAndSupplies = findViewById(R.id.accessories_supplies);
        TextView cameras = findViewById(R.id.cameras);

        televisionAndVideo.setOnClickListener(view -> {
            Intent intent = new Intent(ElectronicsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Electronics");
            startActivity(intent);
        });

        homeAudio.setOnClickListener(view -> {
            Intent intent = new Intent(ElectronicsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Electronics");
            startActivity(intent);
        });

        accessoriesAndSupplies.setOnClickListener(view -> {
            Intent intent = new Intent(ElectronicsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Electronics");
            startActivity(intent);
        });

        cameras.setOnClickListener(view -> {
            Intent intent = new Intent(ElectronicsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Electronics");
            startActivity(intent);
        });

    }
}