package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class ComputingCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_computing_categories);

        TextView laptops = findViewById(R.id.laptops);
        TextView computers = findViewById(R.id.computers);
        TextView dataStorage = findViewById(R.id.data_storage);
        TextView computerComponents = findViewById(R.id.computer_components);

        laptops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ComputingCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Laptops");
                startActivity(intent);
            }
        });

        computers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ComputingCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Computers");
                startActivity(intent);
            }
        });

        dataStorage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ComputingCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Data Storage");
                startActivity(intent);
            }
        });

        computerComponents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ComputingCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Computer Components");
                startActivity(intent);
            }
        });

    }
}