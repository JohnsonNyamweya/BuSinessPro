package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

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

        diapering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Diapering");
                startActivity(intent);
            }
        });

        babyGear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Baby Gear");
                startActivity(intent);
            }
        });

        bathingAndSkinCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Bathing and Skin Care");
                startActivity(intent);
            }
        });

        apparelAndAccessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Apparel and Accessories");
                startActivity(intent);
            }
        });

        babyAndToddlerToys.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Baby and Toddler Toys");
                startActivity(intent);
            }
        });

        feeding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Feeding");
                startActivity(intent);
            }
        });

        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Safety");
                startActivity(intent);
            }
        });

        pottyTraining.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Potty Training");
                startActivity(intent);
            }
        });

        healthAndBabyCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(BabyProductsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Health and Baby Care");
                startActivity(intent);
            }
        });

    }
}