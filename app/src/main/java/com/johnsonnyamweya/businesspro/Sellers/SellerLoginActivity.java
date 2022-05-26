package com.johnsonnyamweya.businesspro.Sellers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.johnsonnyamweya.businesspro.ForgotPasswordActivity;
import com.johnsonnyamweya.businesspro.R;

public class SellerLoginActivity extends AppCompatActivity {

    private Button sellerLoginButton;
    private EditText edtSellerLoginEmail, edtSellerLoginPassword;
    private TextView forgotPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_login);

        loadingBar = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        sellerLoginButton = (Button) findViewById(R.id.seller_login_btn);
        edtSellerLoginEmail = (EditText) findViewById(R.id.seller_login_email);
        edtSellerLoginPassword = (EditText) findViewById(R.id.seller_login_password);
        forgotPassword = (TextView) findViewById(R.id.seller_forgot_password);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SellerLoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        sellerLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sellerLogin();
            }
        });
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
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                loadingBar.dismiss();

                                Toast.makeText(SellerLoginActivity.this,
                                        "Seller logged in Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SellerLoginActivity.this, SellerHomeActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(SellerLoginActivity.this,
                                        "Login Error " + task.getException().getMessage()
                                        , Toast.LENGTH_SHORT).show();


                            }
                        }
                    });
        }

    }
}