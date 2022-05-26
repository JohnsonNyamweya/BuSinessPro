package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class SecondhandGoodsCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondhand_goods_categories);

        TextView electronic2 = findViewById(R.id.electronics2);
        TextView fashion2 = findViewById(R.id.fashion2);
        TextView gaming2 = findViewById(R.id.gaming2);
        TextView sportingGoods2 = findViewById(R.id.sporting_goods2);
        TextView gardenOutdoors2 = findViewById(R.id.garden_outdoors2);
        TextView homeAndBeauty2 = findViewById(R.id.home_beauty2);
        TextView phoneAndTablets2 = findViewById(R.id.phones_tablets2);
        TextView computing2 = findViewById(R.id.computing2);
        TextView healthAndBeauty2 = findViewById(R.id.healthy_beauty2);
        TextView babyProducts2 = findViewById(R.id.baby_products2);

        electronic2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Electronics2");
                startActivity(intent);
            }
        });

        fashion2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Fashion2");
                startActivity(intent);
            }
        });

        gaming2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Gaming2");
                startActivity(intent);
            }
        });

        sportingGoods2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Sporting Goods2");
                startActivity(intent);
            }
        });

        gardenOutdoors2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Garden Outdoors2");
                startActivity(intent);
            }
        });

        homeAndBeauty2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Home and Beauty2");
                startActivity(intent);
            }
        });

        phoneAndTablets2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Phone and Tablets2");
                startActivity(intent);
            }
        });

        computing2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Computing2");
                startActivity(intent);
            }
        });

        healthAndBeauty2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Health and Beauty2");
                startActivity(intent);
            }
        });

        babyProducts2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SecondhandGoodsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Baby Products2");
                startActivity(intent);
            }
        });

    }
}