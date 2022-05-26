package com.johnsonnyamweya.businesspro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private Button btnResetPassword;
    private EditText edtEmail;
    ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        mAuth = FirebaseAuth.getInstance();

        edtEmail = findViewById(R.id.edt_forgot_password_email);
        btnResetPassword = (Button) findViewById(R.id.btn_forgot_password);
        progressBar = findViewById(R.id.pb_loading);

        btnResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetPassword();
            }
        });

    }

    private void resetPassword() {

        String txtEmail = edtEmail.getText().toString();

        if (!Patterns.EMAIL_ADDRESS.matcher(txtEmail).matches()){
            edtEmail.setError("Please enter valid email");
            edtEmail.requestFocus();
            return;
        }

        progressBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(txtEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Toast.makeText(ForgotPasswordActivity.this,
                            "Please Check Your Email To Reset Password", Toast.LENGTH_SHORT).show();

                    progressBar.setVisibility(View.GONE);

                    Intent intent = new Intent(ForgotPasswordActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(ForgotPasswordActivity.this,
                            "Error " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}