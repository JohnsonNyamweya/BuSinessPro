package com.johnsonnyamweya.businesspro.SellerAddCategories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;

public class BabyProductsCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_products_categories);

        TextView diapering = findViewById(R.id.diapering);
        TextView babyGear = findViewById(R.id.baby_gear);
        TextView bathingAndSkinCare = findViewById(R.id.bathing_skin_care);
        TextView apparelAndAccessories = findViewById(R.id.apparel_and_accessories);
        TextView babyAndToddlerToys = findViewById(R.id.baby_and_toddler_toys);
        TextView feeding = findViewById(R.id.feeding);
        TextView safety = findViewById(R.id.safety);
        TextView pottyTraining = findViewById(R.id.potty_training);
        TextView healthAndBabyCare = findViewById(R.id.health_and_babyCare);

        diapering.setOnClickListener(view -> {
            Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

        babyGear.setOnClickListener(view -> {
            Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

        bathingAndSkinCare.setOnClickListener(view -> {
            Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

        apparelAndAccessories.setOnClickListener(view -> {
            Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

        babyAndToddlerToys.setOnClickListener(view -> {
            Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

        feeding.setOnClickListener(view -> {
            Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

        safety.setOnClickListener(view -> {
            Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

        pottyTraining.setOnClickListener(view -> {
            Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

        healthAndBabyCare.setOnClickListener(view -> {
            Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

    }
}