package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class HomeAndBeautyCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_and_beauty_categories);

        TextView homeAndKitchen = findViewById(R.id.home_and_kitchen);
        TextView smallAppliances = findViewById(R.id.small_appliances);
        TextView cookingAppliances = findViewById(R.id.cooking_appliances);
        TextView officeProducts = findViewById(R.id.office_products);

        homeAndKitchen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Home and Kitchen");
                startActivity(intent);
            }
        });

        smallAppliances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Small Appliances");
                startActivity(intent);
            }
        });

        cookingAppliances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Cooking Appliances");
                startActivity(intent);
            }
        });

        officeProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Office Products");
                startActivity(intent);
            }
        });

    }
}