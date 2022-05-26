package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class GardenAndOutdoorsCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garden_and_outdoors_categories);

        TextView gardeningAndLawnCare = findViewById(R.id.gardening_and_lawn_care);
        TextView grillsAndOutdoorCooking = findViewById(R.id.grills_and_outdoor_cooking);
        TextView outDoorDecor = findViewById(R.id.outdoor_decor);

        gardeningAndLawnCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GardenAndOutdoorsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Gardening and Lawn Care");
                startActivity(intent);
            }
        });
        grillsAndOutdoorCooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GardenAndOutdoorsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Grills and Outdoor Cooking");
                startActivity(intent);
            }
        });

        outDoorDecor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GardenAndOutdoorsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Outdoor Decor");
                startActivity(intent);
            }
        });

    }
}