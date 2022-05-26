package com.johnsonnyamweya.businesspro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.johnsonnyamweya.businesspro.Admins.AdminLoginRegisterActivity;
import com.johnsonnyamweya.businesspro.Deliverer.DelivererLoginActivity;
import com.johnsonnyamweya.businesspro.Sellers.SellerLoginActivity;
import com.johnsonnyamweya.businesspro.Sellers.SellerRegistrationActivity;
import com.johnsonnyamweya.businesspro.Users.UserLoginRegisterActivity;

public class MainActivity extends AppCompatActivity {

    private TextView txtAdmin, txtSeller, txtUser, txtDeliverer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAdmin = findViewById(R.id.admin_link);
        txtSeller = findViewById(R.id.seller_link);
        txtUser = findViewById(R.id.user_link);
        txtDeliverer = findViewById(R.id.deliverer_link);

        txtAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdminLoginRegisterActivity.class);
                startActivity(intent);
            }
        });

        txtSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SellerLoginActivity.class);
                startActivity(intent);
            }
        });

        txtUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserLoginRegisterActivity.class);
                startActivity(intent);
            }
        });

        txtDeliverer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DelivererLoginActivity.class);
                startActivity(intent);
            }
        });

    }
}