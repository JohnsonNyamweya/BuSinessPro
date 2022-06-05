package com.johnsonnyamweya.businesspro.Admins;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.johnsonnyamweya.businesspro.Deliverer.DelivererRegistrationActivity;
import com.johnsonnyamweya.businesspro.MainActivity;
import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerRegistrationActivity;

public class AdminHomeActivity extends AppCompatActivity {

    private Button logoutButton, checkOrdersButton, registerSeller, registerDeliverer, checkApproveProductsBtn,
    viewSellers, viewDeliverers;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        mAuth = FirebaseAuth.getInstance();

        logoutButton = (Button) findViewById(R.id.admin_logout_btn);
        checkOrdersButton = (Button) findViewById(R.id.admin_check_orders_btn);
        registerSeller = (Button) findViewById(R.id.admin_register_seller_btn);
        registerDeliverer = (Button) findViewById(R.id.admin_register_deliverer_btn);
        checkApproveProductsBtn = (Button) findViewById(R.id.admin_check_and_approve_orders_btn);
        viewSellers = (Button) findViewById(R.id.admin_view_sellers_available);
        viewDeliverers = (Button) findViewById(R.id.admin_view_deliverers_available);

        registerSeller.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomeActivity.this, SellerRegistrationActivity.class);
                startActivity(intent);
            }
        });

        registerDeliverer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomeActivity.this, DelivererRegistrationActivity.class);
                startActivity(intent);
            }
        });

        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();

                Intent intent = new Intent(AdminHomeActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            }
        });

        checkOrdersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomeActivity.this, AdminCheckNewOrdersActivity.class);
                startActivity(intent);

            }
        });

        checkApproveProductsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AdminHomeActivity.this, AdminCheckNewProductsActivity.class);
                startActivity(intent);
            }
        });

        viewSellers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewSellersIntent = new Intent(AdminHomeActivity.this, SellersListActivity.class);
                startActivity(viewSellersIntent);
            }
        });

        viewDeliverers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewDeliverersIntent = new Intent(AdminHomeActivity.this, DeliverersListActivity.class);
                startActivity(viewDeliverersIntent);
            }
        });

    }
}