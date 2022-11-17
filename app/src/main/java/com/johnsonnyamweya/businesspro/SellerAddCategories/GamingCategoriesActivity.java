package com.johnsonnyamweya.businesspro.SellerAddCategories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;

public class GamingCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_categories);

        TextView playstation = findViewById(R.id.playstation);
        TextView digitalGames = findViewById(R.id.digital_games);
        TextView pcGaming = findViewById(R.id.pc_gaming);
        TextView sonyPsp = findViewById(R.id.sony_psp);

        playstation.setOnClickListener(view -> {
            Intent intent = new Intent(GamingCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Gaming");
            startActivity(intent);
        });

        digitalGames.setOnClickListener(view -> {
            Intent intent = new Intent(GamingCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Gaming");
            startActivity(intent);
        });

        pcGaming.setOnClickListener(view -> {
            Intent intent = new Intent(GamingCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Gaming");
            startActivity(intent);
        });

        sonyPsp.setOnClickListener(view -> {
            Intent intent = new Intent(GamingCategoriesActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Gaming");
            startActivity(intent);
        });

    }
}