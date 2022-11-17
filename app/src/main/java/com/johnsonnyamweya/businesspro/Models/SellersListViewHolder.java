package com.johnsonnyamweya.businesspro.Models;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.johnsonnyamweya.businesspro.Interface.ItemClickListener;
import com.johnsonnyamweya.businesspro.R;

public class SellersListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public ItemClickListener listener;

    public TextView sellerListName, sellerListPhone, sellerListAddress, sellerListEmail;

    public SellersListViewHolder(@NonNull View itemView) {
        super(itemView);

        sellerListName = itemView.findViewById(R.id.seller_details_list_name);
        sellerListPhone = itemView.findViewById(R.id.seller_details_list_phone_number);
        sellerListEmail = itemView.findViewById(R.id.seller_details_list_email);
        sellerListAddress = itemView.findViewById(R.id.seller_list_details_address);

    }

    @Override
    public void onClick(View view) {
        listener.onclick(view, getAdapterPosition(), false);
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }
}
