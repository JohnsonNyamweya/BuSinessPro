package com.johnsonnyamweya.businesspro.SellerAddCategories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;

public class ComputingCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computing_categories);

        TextView laptops = findViewById(R.id.laptops);
        TextView computers = findViewById(R.id.computers);
        TextView dataStorage = findViewById(R.id.data_storage);
        TextView computerComponents = findViewById(R.id.computer_components);

        laptops.setOnClickListener(view -> {
            Intent intent = new Intent(ComputingCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Computing");
            startActivity(intent);
        });

        computers.setOnClickListener(view -> {
            Intent intent = new Intent(ComputingCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Computing");
            startActivity(intent);
        });

        dataStorage.setOnClickListener(view -> {
            Intent intent = new Intent(ComputingCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Computing");
            startActivity(intent);
        });

        computerComponents.setOnClickListener(view -> {
            Intent intent = new Intent(ComputingCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Computing");
            startActivity(intent);
        });

    }
}