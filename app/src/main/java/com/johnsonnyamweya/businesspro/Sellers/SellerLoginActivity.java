package com.johnsonnyamweya.businesspro.Sellers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.johnsonnyamweya.businesspro.ForgotPasswordActivity;
import com.johnsonnyamweya.businesspro.R;

import java.util.Objects;

public class SellerLoginActivity extends AppCompatActivity {

    private EditText edtSellerLoginEmail, edtSellerLoginPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);

        loadingBar = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        Button sellerLoginButton = findViewById(R.id.seller_login_btn);
        edtSellerLoginEmail = findViewById(R.id.seller_login_email);
        edtSellerLoginPassword = findViewById(R.id.seller_login_password);
        TextView forgotPassword = findViewById(R.id.seller_forgot_password);

        forgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(SellerLoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        sellerLoginButton.setOnClickListener(view -> sellerLogin());
    }

    private void sellerLogin() {

        final String email = edtSellerLoginEmail.getText().toString();
        final String password = edtSellerLoginPassword.getText().toString();

        loadingBar.setTitle("Seller Account login");
        loadingBar.setMessage("Please wait, while we are checking credentials");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        if (TextUtils.isEmpty(email)) {
            edtSellerLoginEmail.setError("Email cannot be empty");
            edtSellerLoginEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            edtSellerLoginPassword.setError("Password cannot be empty");
            edtSellerLoginPassword.requestFocus();

            loadingBar.dismiss();

        }

        else{
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()){
                            loadingBar.dismiss();

                            Toast.makeText(SellerLoginActivity.this,
                                    "Seller logged in Successfully", Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();
                            Intent intent = new Intent(SellerLoginActivity.this, SellerHomeActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(SellerLoginActivity.this,
                                    "Login Error " + Objects.requireNonNull(task.getException()).getMessage()
                                    , Toast.LENGTH_SHORT).show();
                            loadingBar.dismiss();


                        }
                    });
        }

    }
}