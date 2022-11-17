package com.johnsonnyamweya.businesspro.Users;

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
import com.johnsonnyamweya.businesspro.Admins.AdminLoginRegisterActivity;
import com.johnsonnyamweya.businesspro.ForgotPasswordActivity;
import com.johnsonnyamweya.businesspro.R;

import java.util.Objects;

public class UserLoginRegisterActivity extends AppCompatActivity {

    private TextView txtUserLogin, txtUserDoNotHaveAccount, txtUserHaveAccount, txtUserForgotPassword;
    private EditText edtUserEmail,edtUserPassword;
    private Button btnUserLogin, btnUserRegister;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login_register);

        mAuth = FirebaseAuth.getInstance();

        txtUserLogin = findViewById(R.id.txt_user_login);
        txtUserForgotPassword = findViewById(R.id.user_forgot_password_link);
        txtUserDoNotHaveAccount = findViewById(R.id.txt_user_do_not_have_account);
        txtUserHaveAccount = findViewById(R.id.user_have_account);
        edtUserEmail = findViewById(R.id.edt_user_email);
        edtUserPassword = findViewById(R.id.edt_user_password);
        btnUserLogin = findViewById(R.id.btn_user_login);
        btnUserRegister = findViewById(R.id.btn_user_register);

        txtUserForgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(UserLoginRegisterActivity.this, ForgotPasswordActivity.class);
            startActivity(intent);
        });

        txtUserHaveAccount.setOnClickListener(view -> {
            btnUserRegister.setVisibility(View.GONE);
            txtUserLogin.setText("LOGIN");
            txtUserDoNotHaveAccount.setVisibility(View.VISIBLE);
            txtUserHaveAccount.setVisibility(View.GONE);
            txtUserForgotPassword.setVisibility(View.VISIBLE);
            btnUserLogin.setVisibility(View.VISIBLE);
        });

        txtUserDoNotHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnUserRegister.setVisibility(View.VISIBLE);
                txtUserLogin.setText("REGISTER");
                txtUserForgotPassword.setVisibility(View.GONE);
                txtUserHaveAccount.setVisibility(View.VISIBLE);
                txtUserDoNotHaveAccount.setVisibility(View.GONE);
                btnUserLogin.setVisibility(View.GONE);
            }
        });

        btnUserLogin.setOnClickListener(view -> sellerLogin());

        btnUserRegister.setOnClickListener(view -> sellerRegister());

    }

    private void sellerRegister() {

        String email = edtUserEmail.getText().toString();
        String password = edtUserPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(UserLoginRegisterActivity.this,
                    "Please enter your email", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(UserLoginRegisterActivity.this,
                    "Please enter your password", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()){
                            Toast.makeText(UserLoginRegisterActivity.this,
                                    "You are registered successfully", Toast.LENGTH_SHORT).show();

                            btnUserRegister.setVisibility(View.GONE);
                            txtUserLogin.setText("LOGIN");

                            Intent intent = new Intent(UserLoginRegisterActivity.this,
                                    UserLoginRegisterActivity.class);
                            startActivity(intent);

                        }
                        else{
                            Toast.makeText(UserLoginRegisterActivity.this,
                                    "Error " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();

                            Intent intent = new Intent(UserLoginRegisterActivity.this,
                                    AdminLoginRegisterActivity.class);
                            startActivity(intent);
                        }
                    });
        }
    }

    private void sellerLogin() {
        String email = edtUserEmail.getText().toString();
        String password = edtUserPassword.getText().toString();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(UserLoginRegisterActivity.this,
                    "Please enter your email", Toast.LENGTH_SHORT).show();
        }
        else if (TextUtils.isEmpty(password)){
            Toast.makeText(UserLoginRegisterActivity.this,
                    "Please enter your password", Toast.LENGTH_SHORT).show();
        }
        else {
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
                if (task.isSuccessful()){
                    Toast.makeText(UserLoginRegisterActivity.this,
                            "Logged in successfully", Toast.LENGTH_SHORT).show();


                    Intent sellerHomeIntent = new Intent(UserLoginRegisterActivity.this, UserHomeActivity.class);
                    startActivity(sellerHomeIntent);

                }
                else{
                    Toast.makeText(UserLoginRegisterActivity.this,
                            "Error " + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }



    }
}