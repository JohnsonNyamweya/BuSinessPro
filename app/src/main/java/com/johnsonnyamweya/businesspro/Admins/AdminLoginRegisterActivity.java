package com.johnsonnyamweya.businesspro.Admins;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.johnsonnyamweya.businesspro.ForgotPasswordActivity;
import com.johnsonnyamweya.businesspro.R;

public class AdminLoginRegisterActivity extends AppCompatActivity {

    private TextView txtLogin, txtDoNotHaveAccount, haveAccount, txtForgotPassword;
    private EditText edtEmail, edtPassword;
    private Button btnLogin, btnRegister;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_register);

        mAuth = FirebaseAuth.getInstance();

        txtLogin = findViewById(R.id.txt_login);
        txtForgotPassword = findViewById(R.id.forgot_password_link);
        txtDoNotHaveAccount = findViewById(R.id.txt_do_not_have_account);
        haveAccount = findViewById(R.id.have_account);
        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        btnLogin = findViewById(R.id.btn_login);
        btnRegister = findViewById(R.id.btn_register);

        txtForgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(AdminLoginRegisterActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);

        });

        haveAccount.setOnClickListener(view -> {
            btnRegister.setVisibility(View.GONE);
            txtLogin.setText("LOGIN");
            txtDoNotHaveAccount.setVisibility(View.VISIBLE);
            haveAccount.setVisibility(View.GONE);
            txtForgotPassword.setVisibility(View.VISIBLE);
            btnLogin.setVisibility(View.VISIBLE);
        });

        txtDoNotHaveAccount.setOnClickListener(view -> {
            btnRegister.setVisibility(View.VISIBLE);
            txtLogin.setText("REGISTER");
            txtForgotPassword.setVisibility(View.GONE);
            haveAccount.setVisibility(View.VISIBLE);
            txtDoNotHaveAccount.setVisibility(View.GONE);
            btnLogin.setVisibility(View.GONE);
        });

        btnLogin.setOnClickListener(view -> login());

        btnRegister.setOnClickListener(view -> register());

    }

    private void register() {

        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(AdminLoginRegisterActivity.this,
                    "Please enter your email", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(AdminLoginRegisterActivity.this,
                    "Please enter your password", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()){
                            Toast.makeText(AdminLoginRegisterActivity.this,
                                    "You are registered successfully", Toast.LENGTH_SHORT).show();

                            btnRegister.setVisibility(View.GONE);
                            txtLogin.setText("LOGIN");

                            Intent intent = new Intent(AdminLoginRegisterActivity.this, AdminLoginRegisterActivity.class);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(AdminLoginRegisterActivity.this,
                                    "Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(AdminLoginRegisterActivity.this, AdminLoginRegisterActivity.class);
                            startActivity(intent);
                        }
                    });
        }
    }

    private void login() {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(AdminLoginRegisterActivity.this,
                    "Please enter your email", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(AdminLoginRegisterActivity.this,
                    "Please enter your password", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(AdminLoginRegisterActivity.this,
                            "Logged in successfully", Toast.LENGTH_SHORT).show();


                        Intent adminHomeIntent = new Intent(AdminLoginRegisterActivity.this, AdminHomeActivity.class);
                        startActivity(adminHomeIntent);

                }
                else{
                    Toast.makeText(AdminLoginRegisterActivity.this,
                            "Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}