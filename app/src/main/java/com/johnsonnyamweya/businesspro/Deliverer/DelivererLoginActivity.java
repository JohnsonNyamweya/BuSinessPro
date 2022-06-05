package com.johnsonnyamweya.businesspro.Deliverer;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.johnsonnyamweya.businesspro.ForgotPasswordActivity;
import com.johnsonnyamweya.businesspro.R;

public class DelivererLoginActivity extends AppCompatActivity {

    private Button delivererLoginButton;
    private EditText edtDelivererLoginEmail, edtDelivererLoginPassword;
    private TextView forgotPassword;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliverer_login);

        loadingBar = new ProgressDialog(this);
        mAuth = FirebaseAuth.getInstance();

        delivererLoginButton = (Button) findViewById(R.id.deliverer_login_btn);
        edtDelivererLoginEmail = (EditText) findViewById(R.id.deliverer_login_email);
        edtDelivererLoginPassword = (EditText) findViewById(R.id.deliverer_login_password);
        forgotPassword = (TextView) findViewById(R.id.deliverer_forgot_password);

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DelivererLoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent);
            }
        });

        delivererLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                delivererLogin();
            }
        });
    }

    private void delivererLogin () {

        final String email = edtDelivererLoginEmail.getText().toString();
        final String password = edtDelivererLoginPassword.getText().toString();

        loadingBar.setTitle("Deliverer Account login");
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
                    .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                loadingBar.dismiss();

                                Toast.makeText(DelivererLoginActivity.this,
                                        "You logged in Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(DelivererLoginActivity.this, DelivererAccountActivity.class);
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(DelivererLoginActivity.this,
                                        "Login Error " + task.getException().getMessage()
                                        , Toast.LENGTH_SHORT).show();


                            }
                        }
                    });
        }


    }
}