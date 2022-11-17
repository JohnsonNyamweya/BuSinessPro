package com.johnsonnyamweya.businesspro.Admins;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.johnsonnyamweya.businesspro.Deliverer.DelivererRegistrationActivity;
import com.johnsonnyamweya.businesspro.MainActivity;
import com.johnsonnyamweya.businesspro.R;
import com.johnsonnyamweya.businesspro.Sellers.SellerRegistrationActivity;

public class AdminHomeActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        mAuth = FirebaseAuth.getInstance();

        Button logoutButton = findViewById(R.id.admin_logout_btn);
        Button checkOrdersButton = findViewById(R.id.admin_check_orders_btn);
        Button registerSeller = findViewById(R.id.admin_register_seller_btn);
        Button registerDeliverer = findViewById(R.id.admin_register_deliverer_btn);
        Button checkApproveProductsBtn = findViewById(R.id.admin_check_and_approve_orders_btn);
//        Button viewSellersButton = findViewById(R.id.admin_view_sellers_btn);
//        Button viewDeliverersButton = findViewById(R.id.admin_view_deliverers_btn);

        registerSeller.setOnClickListener(view -> {
            Intent intent = new Intent(AdminHomeActivity.this, SellerRegistrationActivity.class);
            startActivity(intent);
        });

        registerDeliverer.setOnClickListener(view -> {
            Intent intent = new Intent(AdminHomeActivity.this, DelivererRegistrationActivity.class);
            startActivity(intent);
        });

        logoutButton.setOnClickListener(view -> {
            mAuth.signOut();

            Intent intent = new Intent(AdminHomeActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        });

        checkOrdersButton.setOnClickListener(view -> {
            Intent intent = new Intent(AdminHomeActivity.this, AdminCheckNewOrdersActivity.class);
            startActivity(intent);

        });

//        viewSellersButton.setOnClickListener(view -> {
//            Intent sellersListIntent = new Intent(AdminHomeActivity.this, SellersListActivity.class);
//            startActivity(sellersListIntent);
//        });
//
//        viewDeliverersButton.setOnClickListener(view -> {
//            Intent deliverersListIntent = new Intent(AdminHomeActivity.this, DeliverersListActivity.class);
//            startActivity(deliverersListIntent);
//        });

        checkApproveProductsBtn.setOnClickListener(view -> {
                Intent intent = new Intent(AdminHomeActivity.this, AdminCheckNewProductsActivity.class);
                startActivity(intent);
        });


    }
}