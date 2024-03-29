package com.johnsonnyamweya.businesspro.Sellers;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.johnsonnyamweya.businesspro.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Objects;

public class SellerAddNewProductActivity extends AppCompatActivity {

    private ImageView inputProductImage;
    private EditText inputProductName, inputProductDescription, inputProductPrice;

    public String categoryName;
    private DatabaseReference productRef;

    private StorageReference productImagesRef;

    private static final int galleryPick = 1;
    private Uri imageUri;

    private ProgressDialog loadingBar;

    private String productRandomKey, downloadImageUrl;
    private String description, price, pName, saveCurrentDate, saveCurrentTime;
    String sName, sAddress, sPhone, sEmail, sID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seller_add_new_product);

        categoryName = getIntent().getExtras().get("category").toString();

        productImagesRef = FirebaseStorage.getInstance().getReference().child("Product Images");

        productRef = FirebaseDatabase.getInstance().getReference().child("Products");
        DatabaseReference sellersRef = FirebaseDatabase.getInstance().getReference().child("Sellers");

        loadingBar = new ProgressDialog(this);

        Button addNewProductButton = findViewById(R.id.add_new_product);
        inputProductImage = findViewById(R.id.select_product_image);
        inputProductName = findViewById(R.id.product_name);
        inputProductDescription = findViewById(R.id.product_description);
        inputProductPrice = findViewById(R.id.product_price);


        inputProductImage.setOnClickListener(view -> openGallery());

        addNewProductButton.setOnClickListener(view -> validateProductData());

        sellersRef.child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        if (snapshot.exists()){
                            sName = Objects.requireNonNull(snapshot.child("name").getValue()).toString();
                            sAddress = Objects.requireNonNull(snapshot.child("address").getValue()).toString();
                            sPhone = Objects.requireNonNull(snapshot.child("phone").getValue()).toString();
                            sID = Objects.requireNonNull(snapshot.child("sid").getValue()).toString();
                            sEmail = Objects.requireNonNull(snapshot.child("email").getValue()).toString();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

    }


    private void openGallery() {

        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");
        startActivityForResult(galleryIntent, galleryPick);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == galleryPick && resultCode == RESULT_OK && data != null){
            imageUri = data.getData();
            inputProductImage.setImageURI(imageUri);
        }
    }

    private void validateProductData() {

        description = inputProductDescription.getText().toString();
        price = inputProductPrice.getText().toString();
        pName = inputProductName.getText().toString();


        if (imageUri == null){
            Toast.makeText(this, "Product image is mandatory", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(description)){
            Toast.makeText(this, "Please write product description", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(price)){
            Toast.makeText(this, "Please write product price", Toast.LENGTH_SHORT).show();
        }

        else if (TextUtils.isEmpty(pName)){
            Toast.makeText(this, "Please write product name", Toast.LENGTH_SHORT).show();
        }

        else{
            storeProductInformation();
        }

    }

    private void storeProductInformation() {

        loadingBar.setTitle("Add New Product");
        loadingBar.setMessage("Dear Seller, Please wait while we are adding the new product");
        loadingBar.setCanceledOnTouchOutside(false);
        loadingBar.show();

        Calendar calendar = Calendar.getInstance();


        SimpleDateFormat currentDate = new SimpleDateFormat("MMM dd, yyyy");
        saveCurrentDate = currentDate.format(calendar.getTime());

        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm:ss a");
        saveCurrentTime = currentTime.format(calendar.getTime());

        productRandomKey = saveCurrentDate + saveCurrentTime;

        StorageReference filePath = productImagesRef
                .child(imageUri.getLastPathSegment() + productRandomKey + ".jpg");

        final UploadTask uploadTask = filePath.putFile(imageUri);

        uploadTask.addOnFailureListener(e -> {
            String message = e.toString();
            Toast.makeText(SellerAddNewProductActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
            loadingBar.dismiss();
        }).addOnSuccessListener(taskSnapshot -> {
            Toast.makeText(SellerAddNewProductActivity.this,
                    " Product image uploaded successfully...", Toast.LENGTH_SHORT).show();
            Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                @Override
                public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                    if (!task.isSuccessful()){
                        throw Objects.requireNonNull(task.getException());
                    }

                    downloadImageUrl = filePath.getDownloadUrl().toString();
                    return filePath.getDownloadUrl();

                }
            }).addOnCompleteListener(task -> {

                if (task.isSuccessful()){

                    downloadImageUrl = task.getResult().toString();

                    Toast.makeText(SellerAddNewProductActivity.this, "Got the product image Url successfully..",
                            Toast.LENGTH_SHORT).show();
                    saveProductInfoToDatabase();
                }
            });
        });


    }

    private void saveProductInfoToDatabase() {

        HashMap<String, Object> productMap = new HashMap<>();

        productMap.put("pid", productRandomKey);
        productMap.put("date", saveCurrentDate);
        productMap.put("time", saveCurrentTime);
        productMap.put("description", description);
        productMap.put("image", downloadImageUrl);
        productMap.put("category", categoryName);
        productMap.put("price", price);
        productMap.put("pName", pName);

        productMap.put("sellerName", sName);
        productMap.put("sellerAddress", sAddress);
        productMap.put("sellerPhone", sPhone);
        productMap.put("email", sEmail);
        productMap.put("sid", sID);
        productMap.put("productState", "Not Approved");

        productRef.child(productRandomKey).updateChildren(productMap)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){

                        Intent intent = new Intent(SellerAddNewProductActivity.this,
                                SellerHomeActivity.class);
                        startActivity(intent);

                        loadingBar.dismiss();
                        Toast.makeText(SellerAddNewProductActivity.this, "Product is added successfully...",
                                Toast.LENGTH_SHORT).show();
                    }
                    else{
                        loadingBar.dismiss();
                        String message = Objects.requireNonNull(task.getException()).toString();
                        Toast.makeText(SellerAddNewProductActivity.this, "Error: " + message, Toast.LENGTH_SHORT).show();
                    }
                });

    }

}