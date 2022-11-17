package com.johnsonnyamweya.businesspro;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.johnsonnyamweya.businesspro.Admins.AdminLoginRegisterActivity;
import com.johnsonnyamweya.businesspro.Sellers.SellerLoginActivity;
import com.johnsonnyamweya.businesspro.Users.UserLoginRegisterActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtAdmin = findViewById(R.id.admin_link);
        TextView txtSeller = findViewById(R.id.seller_link);
        TextView txtUser = findViewById(R.id.user_link);
//        TextView txtDeliverer = findViewById(R.id.deliverer_link);

        txtAdmin.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AdminLoginRegisterActivity.class);
            startActivity(intent);
        });

        txtSeller.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, SellerLoginActivity.class);
            startActivity(intent);
        });

        txtUser.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, UserLoginRegisterActivity.class);
            startActivity(intent);
        });

//        txtDeliverer.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this, DelivererLoginActivity.class);
//            startActivity(intent);
//        });

    }
}