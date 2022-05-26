package com.johnsonnyamweya.businesspro.Sellers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsonnyamweya.businesspro.R;

import java.util.HashMap;

public class SellerRegistrationActivity extends AppCompatActivity {

    private Button sellerRegisterBtn;
    private EditText sellerName, sellerPhone, sellerEmail, sellerPassword, sellerAddress;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;
    String name, phone, password, email, address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_registration);

        loadingBar = new ProgressDialog(this);

        sellerRegisterBtn = (Button) findViewById(R.id.seller_register_btn);
        sellerName = (EditText) findViewById(R.id.seller_name);
        sellerPhone = (EditText) findViewById(R.id.seller_phone);
        sellerEmail = (EditText) findViewById(R.id.seller_email);
        sellerPassword = (EditText) findViewById(R.id.seller_password);
        sellerAddress = (EditText) findViewById(R.id.seller_address);

        mAuth = FirebaseAuth.getInstance();


        sellerRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerSeller();
            }
        });
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
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                final DatabaseReference rootRef;

                                rootRef = FirebaseDatabase.getInstance().getReference();

                                String sid = mAuth.getCurrentUser().getUid();

                                HashMap<String, Object> sellerMap = new HashMap<>();

                                sellerMap.put("sid", sid);
                                sellerMap.put("email", email);
                                sellerMap.put("phone", phone);
                                sellerMap.put("address", address);
                                sellerMap.put("name", name);


                                rootRef.child("Sellers").child(sid).updateChildren(sellerMap)
                                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if (task.isSuccessful()) {

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
                                                            "Registration Error " + task.getException().getMessage()
                                                            , Toast.LENGTH_SHORT).show();

                                                }
                                            }

                                        });
                            }
                        }
                    });
        } else {
            Toast.makeText(this, "Please fill out all registration fields", Toast.LENGTH_SHORT).show();
        }

    }
}