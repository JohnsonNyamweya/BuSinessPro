package com.johnsonnyamweya.businesspro.SellerAddCategories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;

public class GardenAndOutdoorsCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_and_outdoors_categories);

        TextView gardeningAndLawnCare = findViewById(R.id.gardening_and_lawn_care);
        TextView grillsAndOutdoorCooking = findViewById(R.id.grills_and_outdoor_cooking);
        TextView outDoorDecor = findViewById(R.id.outdoor_decor);

        gardeningAndLawnCare.setOnClickListener(view -> {
            Intent intent = new Intent(GardenAndOutdoorsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Garden and Outdoors");
            startActivity(intent);
        });
        grillsAndOutdoorCooking.setOnClickListener(view -> {
            Intent intent = new Intent(GardenAndOutdoorsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Garden and Outdoors");
            startActivity(intent);
        });

        outDoorDecor.setOnClickListener(view -> {
            Intent intent = new Intent(GardenAndOutdoorsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Garden and Outdoors");
            startActivity(intent);
        });

    }
}