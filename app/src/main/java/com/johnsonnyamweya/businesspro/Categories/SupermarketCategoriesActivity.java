package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

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

        food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupermarketCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Food");
                startActivity(intent);
            }
        });

        beerWinesSpirits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupermarketCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Beer, Wines and Spirits");
                startActivity(intent);
            }
        });

        drinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupermarketCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Drinks");
                startActivity(intent);
            }
        });

        householdSupplies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SupermarketCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Household Supplies");
                startActivity(intent);
            }
        });

    }
}