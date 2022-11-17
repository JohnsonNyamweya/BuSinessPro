package com.johnsonnyamweya.businesspro.Admins;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.johnsonnyamweya.businesspro.R;

public class DeliverersListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deliverers_list);

        RecyclerView deliverersListRv = findViewById(R.id.deliverers_list_rv);
        deliverersListRv.setLayoutManager(new LinearLayoutManager(this));

    }
}