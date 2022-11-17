package com.johnsonnyamweya.businesspro.Sellers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsonnyamweya.businesspro.R;

import java.util.HashMap;
import java.util.Objects;

public class SellerRegistrationActivity extends AppCompatActivity {

    private EditText sellerName, sellerPhone, sellerEmail, sellerPassword, sellerAddress;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;
    String name, phone, password, email, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_registration);

        loadingBar = new ProgressDialog(this);

        Button sellerRegisterBtn = findViewById(R.id.seller_register_btn);
        sellerName = findViewById(R.id.seller_name);
        sellerPhone = findViewById(R.id.seller_phone);
        sellerEmail = findViewById(R.id.seller_email);
        sellerPassword = findViewById(R.id.seller_password);
        sellerAddress = findViewById(R.id.seller_address);

        mAuth = FirebaseAuth.getInstance();


        sellerRegisterBtn.setOnClickListener(view -> registerSeller());
    }

    private void registerSeller() {
        name = sellerName.getText().toString();
        phone = sellerPhone.getText().toString();
        email = sellerEmail.getText().toString();
        password = sellerPassword.getText().toString();
        address = sellerAddress.getText().toString();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(email)
                && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(address)) {

            loadingBar.setTitle("Creating seller Account");
            loadingBar.setMessage("Please wait, while we are checking credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();


            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            final DatabaseReference rootRef;

                            rootRef = FirebaseDatabase.getInstance().getReference();

                            String sid = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();

                            HashMap<String, Object> sellerMap = new HashMap<>();

                            sellerMap.put("sid", sid);
                            sellerMap.put("email", email);
                            sellerMap.put("phone", phone);
                            sellerMap.put("address", address);
                            sellerMap.put("name", name);


                            rootRef.child("Sellers").child(sid).updateChildren(sellerMap)
                                    .addOnCompleteListener(task1 -> {
                                        if (task1.isSuccessful()) {

                                            loadingBar.dismiss();

                                            Toast.makeText(SellerRegistrationActivity.this,
                                                    "You are registered successfully", Toast.LENGTH_SHORT).show();

                                            Intent intent = new Intent(SellerRegistrationActivity.this
                                                    , SellerLoginActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(SellerRegistrationActivity.this,
                                                    "Registration Error " + Objects.requireNonNull(task1.getException()).getMessage()
                                                    , Toast.LENGTH_SHORT).show();

                                        }
                                    });
                        }
                    });
        } else {
            Toast.makeText(this, "Please fill out all registration fields", Toast.LENGTH_SHORT).show();
        }

    }
}