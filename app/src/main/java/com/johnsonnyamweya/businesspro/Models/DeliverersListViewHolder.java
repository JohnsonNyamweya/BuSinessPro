package com.johnsonnyamweya.businesspro.Models;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.johnsonnyamweya.businesspro.Interface.ItemClickListener;
import com.johnsonnyamweya.businesspro.R;

public class DeliverersListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    private ItemClickListener listener;

    private TextView name, phoneNumber, email, address, carBikeName;

    public DeliverersListViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.deliverer_details_list_name);
        phoneNumber = itemView.findViewById(R.id.deliverer_details_list_phone_number);
        email = itemView.findViewById(R.id.deliverer_details_list_email);
        address = itemView.findViewById(R.id.deliverer_list_details_address);
        carBikeName = itemView.findViewById(R.id.deliverer_list_details_car_bike_name);

    }

    @Override
    public void onClick(View view) {
        listener.onclick(view, getAbsoluteAdapterPosition(), false);
    }

    public void setItemClickListener(ItemClickListener listener){
        this.listener = listener;
    }

}
