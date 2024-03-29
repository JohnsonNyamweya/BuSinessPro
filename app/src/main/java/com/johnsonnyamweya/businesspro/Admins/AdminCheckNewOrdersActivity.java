package com.johnsonnyamweya.businesspro.Admins;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.johnsonnyamweya.businesspro.Models.AdminOrders;
import com.johnsonnyamweya.businesspro.R;

public class AdminCheckNewOrdersActivity extends AppCompatActivity {

    private RecyclerView ordersList;
    private DatabaseReference ordersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_check_new_orders);

        ordersRef = FirebaseDatabase.getInstance().getReference().child("Orders");

        ordersList = findViewById(R.id.new_orders_list_rv);
        ordersList.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<AdminOrders> options = new FirebaseRecyclerOptions.Builder<AdminOrders>()
                .setQuery(ordersRef, AdminOrders.class).build();

        FirebaseRecyclerAdapter<AdminOrders, AdminOrdersViewHolder> adapter =
                new FirebaseRecyclerAdapter<AdminOrders, AdminOrdersViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull AdminOrdersViewHolder holder,
                                                    @SuppressLint("RecyclerView") int position,
                                                    @NonNull AdminOrders model) {

                        holder.userName.setText("Name = " + model.getName());
                        holder.userPhoneNumber.setText("Phone = " + model.getPhone());
                        holder.userTotalPrice.setText("Total Amount = KShs " + model.getTotalAmount());
                        holder.userDateTime.setText("Order at = " + model.getTime() + " " + model.getDate());
                        holder.userShippingAddress.setText("Shipping Address = "
                                + model.getAddress() + " " + model.getCity());

                        holder.showOrdersBtn.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                String uID = getRef(position).getKey();

                                Intent intent = new Intent(AdminCheckNewOrdersActivity.this,
                                        AdminUserOrderProductsActivity.class);
                                intent.putExtra("uid", uID);
                                startActivity(intent);

                            }
                        });

                        holder.itemView.setOnClickListener(view -> {
                            CharSequence options1[] = new CharSequence[]{

                                    "Yes",
                                    "No"

                            };

                            AlertDialog.Builder builder = new AlertDialog.Builder(AdminCheckNewOrdersActivity.this);
                            builder.setTitle("Have you shipped this order?");
                            builder.setItems(options1, (dialogInterface, position1) -> {

                                if (position1 == 0){
                                    String uID = getRef(position1).getKey();

                                    removeOrder(uID);
                                }
                                else {
                                    finish();
                                }

                            });

                            builder.show();

                        });

                    }

                    @NonNull
                    @Override
                    public AdminOrdersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

                        View view = LayoutInflater.from(parent.getContext())
                                .inflate(R.layout.orders_layout, parent, false);
                        AdminOrdersViewHolder holder = new AdminOrdersViewHolder(view);

                        return holder;
                    }
                };

        ordersList.setAdapter(adapter);
        adapter.startListening();

    }

    private void removeOrder(String uID) {

        ordersRef.child(uID).removeValue();
    }

    public static final class AdminOrdersViewHolder extends RecyclerView.ViewHolder {

        private final TextView userName;
        private final TextView userPhoneNumber;
        private final TextView userTotalPrice;
        private final TextView userDateTime;
        private final TextView userShippingAddress;
        public Button showOrdersBtn;

        public AdminOrdersViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.order_user_name);
            userPhoneNumber = itemView.findViewById(R.id.order_phone_number);
            userTotalPrice = itemView.findViewById(R.id.order_total_price);
            userDateTime = itemView.findViewById(R.id.order_date_time);
            userShippingAddress = itemView.findViewById(R.id.order_address_city);
            showOrdersBtn = itemView.findViewById(R.id.show_all_products_btn);

        }
    }
}