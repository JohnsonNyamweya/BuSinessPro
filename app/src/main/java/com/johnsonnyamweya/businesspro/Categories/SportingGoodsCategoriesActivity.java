package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class SportingGoodsCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sporting_goods);

        TextView sportingAndFitness = findViewById(R.id.sporting_fitness);
        TextView sportsNutrition = findViewById(R.id.sports_nutrition);
        TextView outdoorRecreation = findViewById(R.id.outdoor_recreation);

        sportingAndFitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportingGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Sporting and Fitness");
                startActivity(intent);
            }
        });
        sportsNutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportingGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Sports Nutrition");
                startActivity(intent);
            }
        });

        outdoorRecreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SportingGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Outdoor Recreation");
                startActivity(intent);
            }
        });

    }
}