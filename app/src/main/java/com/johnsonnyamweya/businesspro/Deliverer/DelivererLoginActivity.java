package com.johnsonnyamweya.businesspro.Deliverer;

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

public class DelivererLoginActivity extends AppCompatActivity {

    private EditText edtDelivererLoginEmail, edtDelivererLoginPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliverer_login);

        loadingBar = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        Button delivererLoginButton = findViewById(R.id.deliverer_login_btn);
        edtDelivererLoginEmail = findViewById(R.id.deliverer_login_email);
        edtDelivererLoginPassword = findViewById(R.id.deliverer_login_password);
        TextView forgotPassword = findViewById(R.id.deliverer_forgot_password);

        forgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(DelivererLoginActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        delivererLoginButton.setOnClickListener(view -> delivererLogin());
    }

    private void delivererLogin () {

        final String email = edtDelivererLoginEmail.getText().toString();
        final String password = edtDelivererLoginPassword.getText().toString();

        loadingBar.setTitle("Seller Account login");
        loadingBar.setMessage("Please wait, while we are checking credentials");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        if (TextUtils.isEmpty(email)) {
            edtDelivererLoginEmail.setError("Email cannot be empty");
            edtDelivererLoginEmail.requestFocus();
        } else if (TextUtils.isEmpty(password)) {
            edtDelivererLoginPassword.setError("Password cannot be empty");
            edtDelivererLoginPassword.requestFocus();

            loadingBar.dismiss();

        }

        else{
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()){
                            loadingBar.dismiss();

                            Toast.makeText(DelivererLoginActivity.this,
                                    "Seller logged in Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(DelivererLoginActivity.this,
                                    "Login Error " + Objects.requireNonNull(task.getException()).getMessage()
                                    , Toast.LENGTH_SHORT).show();


                        }
                    });
        }


    }
}