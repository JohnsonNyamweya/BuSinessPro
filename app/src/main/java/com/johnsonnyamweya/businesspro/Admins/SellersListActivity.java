package com.johnsonnyamweya.businesspro.Admins;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsonnyamweya.businesspro.Models.SellersList;
import com.johnsonnyamweya.businesspro.Models.SellersListViewHolder;
import com.johnsonnyamweya.businesspro.R;

public class SellersListActivity extends AppCompatActivity {

    RecyclerView sellersRv;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellers_list);

        sellersRv = findViewById(R.id.sellers_list_rv);
        layoutManager = new LinearLayoutManager(this);
        sellersRv.setHasFixedSize(true);
        sellersRv.setLayoutManager(layoutManager);

    }

    @Override
    protected void onStart() {
        super.onStart();

        DatabaseReference sellersListRef = FirebaseDatabase.getInstance().getReference();

        FirebaseRecyclerOptions<SellersList> options = new FirebaseRecyclerOptions.Builder<SellersList>()
                .setQuery(sellersListRef.child("Sellers"), SellersList.class).build();

        FirebaseRecyclerAdapter <SellersList, SellersListViewHolder> adapter =
                new FirebaseRecyclerAdapter<SellersList, SellersListViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull SellersListViewHolder holder,
                                            @SuppressLint("RecyclerView") int position, @NonNull SellersList model) {

                holder.sellerListName.setText(model.getSellerListName());
                holder.sellerListPhone.setText(model.getSellerListPhone());
                holder.sellerListEmail.setText(model.getSellerListEmail());
                holder.sellerListAddress.setText(model.getSellerListAddress());

                holder.itemView.setOnClickListener(view -> {
                    CharSequence options1[] = new CharSequence[]{
                            "Yes",
                            "No"
                    };

                    AlertDialog.Builder builder = new AlertDialog.Builder(SellersListActivity.this);
                    builder.setTitle("Are you sure you want to delete this seller?");
                    builder.setItems(options1, (dialogInterface, i) -> {
                        if (position == 0){
                            sellersListRef.child("Sellers").child("sid").removeValue()
                                    .addOnCompleteListener(task -> {
                                        Toast.makeText(SellersListActivity.this,
                                                "Seller deleted successfullyS", Toast.LENGTH_SHORT).show();

                                        Intent intent = new Intent(SellersListActivity.this, SellersListActivity.class);
                                        startActivity(intent);
                                    });
                        }
                        if (position == 1){
                            finish();
                            Intent intent = new Intent(SellersListActivity.this, SellersListActivity.class);
                            startActivity(intent);
                        }
                    });

                });

            }

            @NonNull
            @Override
            public SellersListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
               View view = LayoutInflater.from(parent.getContext())
                       .inflate(R.layout.sellers_list_details_layout, parent, false);
               SellersListViewHolder sellersHolder = new SellersListViewHolder(view);
               return sellersHolder;
            }
        };

        sellersRv.setAdapter(adapter);
        adapter.startListening();

    }
}