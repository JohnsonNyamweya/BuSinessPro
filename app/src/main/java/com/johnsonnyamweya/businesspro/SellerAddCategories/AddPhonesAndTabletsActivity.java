package com.johnsonnyamweya.businesspro.SellerAddCategories;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerAddNewProductActivity;

public class AddPhonesAndTabletsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_phones_and_tablets);


        TextView mobilePhones = findViewById(R.id.mobile_phones);
        TextView mobilePhoneAccessories = findViewById(R.id.mobile_phones_accessories);
        TextView tablets = findViewById(R.id.tablets);

        mobilePhones.setOnClickListener(view -> {
            Intent intent = new Intent(AddPhonesAndTabletsActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Phones and Tablets");
            startActivity(intent);
        });

        mobilePhoneAccessories.setOnClickListener(view -> {
            Intent intent = new Intent(AddPhonesAndTabletsActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Phones and Tablets");
            startActivity(intent);
        });

        tablets.setOnClickListener(view -> {
            Intent intent = new Intent(AddPhonesAndTabletsActivity.this,
                    SellerAddNewProductActivity.class);
            intent.putExtra("category", "Phones and Tablets");
            startActivity(intent);
        });

    }
}