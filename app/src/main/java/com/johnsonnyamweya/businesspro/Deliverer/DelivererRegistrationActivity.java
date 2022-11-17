package com.johnsonnyamweya.businesspro.Deliverer;

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

public class DelivererRegistrationActivity extends AppCompatActivity {

    private EditText delivererName, delivererPhone, delivererEmail, delivererPassword,
            delivererAddress, delivererMotorbikeName;
    private FirebaseAuth mAuth;
    private ProgressDialog loadingBar;
    String name, phone, password, email, address, motorbikeName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliverer_registration);

        loadingBar = new ProgressDialog(this);

        Button delivererRegisterBtn = findViewById(R.id.deliverer_register_btn);
        delivererName = findViewById(R.id.deliverer_name);
        delivererPhone = findViewById(R.id.deliverer_phone);
        delivererEmail = findViewById(R.id.deliverer_email);
        delivererPassword = findViewById(R.id.deliverer_password);
        delivererAddress = findViewById(R.id.deliverer_address);
        delivererMotorbikeName = findViewById(R.id.deliverer_bike_name);


        mAuth = FirebaseAuth.getInstance();


        delivererRegisterBtn.setOnClickListener(view -> registerDeliverer());
    }

    private void registerDeliverer() {
        name = delivererName.getText().toString();
        phone = delivererPhone.getText().toString();
        email = delivererEmail.getText().toString();
        password = delivererPassword.getText().toString();
        address = delivererAddress.getText().toString();
        motorbikeName = delivererMotorbikeName.getText().toString();

        if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(phone) && !TextUtils.isEmpty(email)
                && !TextUtils.isEmpty(password) && !TextUtils.isEmpty(address)
                && !TextUtils.isEmpty(motorbikeName)) {

            loadingBar.setTitle("Creating Deliverer Account");
            loadingBar.setMessage("Please wait, while we are checking credentials");
            loadingBar.setCanceledOnTouchOutside(false);
            loadingBar.show();


            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            final DatabaseReference rootRef;

                            rootRef = FirebaseDatabase.getInstance().getReference();

                            String dID = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();

                            HashMap<String, Object> delivererMap = new HashMap<>();

                            delivererMap.put("dId", dID);
                            delivererMap.put("email", email);
                            delivererMap.put("phone", phone);
                            delivererMap.put("address", address);
                            delivererMap.put("name", name);
                            delivererMap.put("motorbikeName", motorbikeName);


                            rootRef.child("Deliverers").child(dID).updateChildren(delivererMap)
                                    .addOnCompleteListener(task1 -> {
                                        if (task1.isSuccessful()) {

                                            loadingBar.dismiss();

                                            Toast.makeText(DelivererRegistrationActivity.this,
                                                    "You are registered successfully", Toast.LENGTH_SHORT).show();

                                            Intent intent = new Intent(DelivererRegistrationActivity.this
                                                    , DelivererLoginActivity.class);
                                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                            finish();
                                        } else {
                                            Toast.makeText(DelivererRegistrationActivity.this,
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