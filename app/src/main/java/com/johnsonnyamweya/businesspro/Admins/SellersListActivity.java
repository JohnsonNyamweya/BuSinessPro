package com.johnsonnyamweya.businesspro.Admins;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.johnsonnyamweya.businesspro.R;

public class SellersListActivity extends AppCompatActivity {

    private RecyclerView sellersRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellers_list);

        sellersRv = (RecyclerView) findViewById(R.id.sellers_list_rv);
        sellersRv.setLayoutManager(new LinearLayoutManager(this));

    }
}