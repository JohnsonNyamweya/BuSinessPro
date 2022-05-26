package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class ElectronicsCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electronics_categories);

        TextView televisionAndVideo = findViewById(R.id.television_video);
        TextView homeAudio = findViewById(R.id.home_audio);
        TextView accessoriesAndSupplies = findViewById(R.id.accessories_supplies);
        TextView cameras = findViewById(R.id.cameras);

        televisionAndVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectronicsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                startActivity(intent);
            }
        });

        homeAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectronicsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                startActivity(intent);
            }
        });

        accessoriesAndSupplies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectronicsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                startActivity(intent);
            }
        });

        cameras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ElectronicsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                startActivity(intent);
            }
        });

    }
}