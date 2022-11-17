package com.johnsonnyamweya.businesspro.SellerAddCategories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;

public class FashionCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_categories);

        TextView womenFashion = findViewById(R.id.women_fashion);
        TextView menFashion = findViewById(R.id.men_fashion);
        TextView baby = findViewById(R.id.baby);
        TextView kidsFashion = findViewById(R.id.kids_fashion);

        womenFashion.setOnClickListener(view -> {
            Intent intent = new Intent(FashionCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Fashion");
            startActivity(intent);
        });

        menFashion.setOnClickListener(view -> {
            Intent intent = new Intent(FashionCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Fashion");
            startActivity(intent);
        });

        baby.setOnClickListener(view -> {
            Intent intent = new Intent(FashionCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Fashion");
            startActivity(intent);
        });

        kidsFashion.setOnClickListener(view -> {
            Intent intent = new Intent(FashionCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Fashion");
            startActivity(intent);
        });

    }
}