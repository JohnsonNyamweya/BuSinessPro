package com.johnsonnyamweya.businesspro.SellerAddCategories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;

public class SupermarketCategoriesActivity extends AppCompatActivity {

    private TextView food, beerWinesSpirits, drinks, householdSupplies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supermarket_category);

        food = findViewById(R.id.supermarket_food);
        beerWinesSpirits = findViewById(R.id.supermarket_beer);
        drinks = findViewById(R.id.supermarket_drinks);
        householdSupplies = findViewById(R.id.supermarket_household_supplies);

        food.setOnClickListener(view -> {
            Intent intent = new Intent(SupermarketCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Supermarkets");
            startActivity(intent);
        });

        beerWinesSpirits.setOnClickListener(view -> {
            Intent intent = new Intent(SupermarketCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Supermarkets");
            startActivity(intent);
        });

        drinks.setOnClickListener(view -> {
            Intent intent = new Intent(SupermarketCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Supermarkets");
            startActivity(intent);
        });

        householdSupplies.setOnClickListener(view -> {
            Intent intent = new Intent(SupermarketCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Supermarkets");
            startActivity(intent);
        });

    }
}