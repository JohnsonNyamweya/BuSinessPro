package com.johnsonnyamweya.businesspro.Sellers;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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



        supermarkets.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Supermarkets");
            startActivity(intent);
        });

        phonesTablets.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Phones and Tablets");
            startActivity(intent);
        });

        computing.setOnClickListener(view -> {

                Intent intent = new Intent(SellerProductsCategoryActivity.this,
                        SellerAddNewProductActivity.class);
            intent.putExtra("category", "Computing");
                startActivity(intent);
        });

        electronics.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Electronics");
            startActivity(intent);
        });

        fashion.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Fashion");
            startActivity(intent);
        });

        gaming.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Gaming");
            startActivity(intent);
        });

        sportingGoods.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Sporting Goods");
            startActivity(intent);
        });

        gardenAndOutDoors.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Garden and Outdoors");
            startActivity(intent);
        });

        homeAndBeauty.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Home and Beauty");
            startActivity(intent);
        });

        healthAndBeauty.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Health and Beauty");
            startActivity(intent);
        });

        babyProducts.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Baby Products");
            startActivity(intent);
        });

        secondhandGoods.setOnClickListener(view -> {
            Intent intent = new Intent(SellerProductsCategoryActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Secondhand Goods");
            startActivity(intent);
        });


    }
}