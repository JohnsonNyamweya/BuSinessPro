package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class HealthAndBeautyCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_and_beauty_categories);

        TextView hairCare = findViewById(R.id.hair_care);
        TextView personalCare = findViewById(R.id.personal_care);
        TextView fragrances = findViewById(R.id.fragrances);
        TextView makeup = findViewById(R.id.makeUp);
        TextView menGrooming = findViewById(R.id.men_grooming);
        TextView oralCare = findViewById(R.id.oral_care);
        TextView healthcare = findViewById(R.id.health_care);

        hairCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Hair Care");
                startActivity(intent);
            }
        });

        personalCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Personal Care");
                startActivity(intent);
            }
        });

        fragrances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Fragrances");
                startActivity(intent);
            }
        });

        makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Makeup");
                startActivity(intent);
            }
        });

        menGrooming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Men Grooming");
                startActivity(intent);
            }
        });

        oralCare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Oral Care");
                startActivity(intent);
            }
        });

        healthcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HealthAndBeautyCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Health Care");
                startActivity(intent);
            }
        });

    }
}