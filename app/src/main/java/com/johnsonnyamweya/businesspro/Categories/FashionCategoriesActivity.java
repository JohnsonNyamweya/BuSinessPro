package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class FashionCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fashion_categories);

        TextView womenFashion = findViewById(R.id.women_fashion);
        TextView menFashion = findViewById(R.id.men_fashion);
        TextView baby = findViewById(R.id.baby);
        TextView kidsFashion = findViewById(R.id.kids_fashion);

        womenFashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FashionCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Women Fashion");
                startActivity(intent);
            }
        });

        menFashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FashionCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Men Fashion");
                startActivity(intent);
            }
        });

        baby.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FashionCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Baby");
                startActivity(intent);
            }
        });

        kidsFashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FashionCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Kids Fashion");
                startActivity(intent);
            }
        });

    }
}