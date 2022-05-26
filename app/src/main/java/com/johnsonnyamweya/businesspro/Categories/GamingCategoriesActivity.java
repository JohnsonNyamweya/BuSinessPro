package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class GamingCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gaming_categories);

        TextView playstation = findViewById(R.id.playstation);
        TextView digitalGames = findViewById(R.id.digital_games);
        TextView pcGaming = findViewById(R.id.pc_gaming);
        TextView sonyPsp = findViewById(R.id.sony_psp);

        playstation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GamingCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Play Station");
                startActivity(intent);
            }
        });

        digitalGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GamingCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Digital Games");
                startActivity(intent);
            }
        });

        pcGaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GamingCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "PC Games");
                startActivity(intent);
            }
        });

        sonyPsp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GamingCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "SonyPSP");
                startActivity(intent);
            }
        });

    }
}