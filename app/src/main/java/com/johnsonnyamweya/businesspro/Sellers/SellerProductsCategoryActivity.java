package com.johnsonnyamweya.businesspro.Sellers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Categories.BabyProductsCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.ComputingCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.ElectronicsCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.FashionCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.GamingCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.GardenAndOutdoorsCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.HealthAndBeautyCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.HomeAndBeautyCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.PhonesAndTabletsCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.SecondhandGoodsCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.SportingGoodsCategoriesActivity;
import com.johnsonnyamweya.businesspro.Categories.SupermarketCategoriesActivity;
import com.johnsonnyamweya.businesspro.R;

public class SellerProductsCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_products_category);

        TextView supermarkets = findViewById(R.id.supermarkets);
        TextView phonesTablets = findViewById(R.id.phones_tablets);
        TextView computing = findViewById(R.id.computing);

        TextView electronics = findViewById(R.id.electronics);
        TextView fashion = findViewById(R.id.fashion);
        TextView gaming = findViewById(R.id.gaming);

        TextView sportingGoods = findViewById(R.id.sporting_goods);
        TextView gardenAndOutDoors = findViewById(R.id.garden_outdoors);
        TextView homeAndBeauty = findViewById(R.id.home_beauty);

        TextView healthAndBeauty = findViewById(R.id.healthy_beauty);
        TextView babyProducts = findViewById(R.id.baby_products);
        TextView secondhandGoods = findViewById(R.id.second_hand_goods);



        supermarkets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        SupermarketCategoriesActivity.class);
                startActivity(intent);
            }
        });

        phonesTablets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        PhonesAndTabletsCategoriesActivity.class);
                startActivity(intent);
            }
        });

        computing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(SellerProductsCategoryActivity.this,
                            ComputingCategoriesActivity.class);
                    startActivity(intent);
            }
        });

        electronics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        ElectronicsCategoriesActivity.class);
                startActivity(intent);
            }
        });

        fashion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        FashionCategoriesActivity.class);
                startActivity(intent);
            }
        });

        gaming.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        GamingCategoriesActivity.class);
                startActivity(intent);
            }
        });

        sportingGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        SportingGoodsCategoriesActivity.class);
                startActivity(intent);
            }
        });

        gardenAndOutDoors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        GardenAndOutdoorsCategoriesActivity.class);
                startActivity(intent);
            }
        });

        homeAndBeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        HomeAndBeautyCategoriesActivity.class);
                startActivity(intent);
            }
        });

        healthAndBeauty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        HealthAndBeautyCategoriesActivity.class);
                startActivity(intent);
            }
        });

        babyProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        BabyProductsCategoriesActivity.class);
                startActivity(intent);
            }
        });

        secondhandGoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        SecondhandGoodsCategoriesActivity.class);
                startActivity(intent);
            }
        });


    }
}