package com.johnsonnyamweya.businesspro.Categories;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;
import com.johnsonnyamweya.businesspro.R;

public class PhonesAndTabletsCategoriesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phones_and_tablets_category);


        TextView mobilePhones = findViewById(R.id.mobile_phones);
        TextView mobilePhoneAccessories = findViewById(R.id.mobile_phones_accessories);
        TextView tablets = findViewById(R.id.tablets);

        mobilePhones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhonesAndTabletsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Mobile Phones");
                startActivity(intent);
            }
        });

        mobilePhoneAccessories.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhonesAndTabletsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Mobile Phone Accessories");
                startActivity(intent);
            }
        });

        tablets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PhonesAndTabletsCategoriesActivity.this,
                        SellerAddNewProductActivity.class);
                intent.putExtra("category", "Tablets");
                startActivity(intent);
            }
        });

    }
}