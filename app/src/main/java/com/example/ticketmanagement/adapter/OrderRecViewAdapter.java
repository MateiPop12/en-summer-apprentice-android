package com.example.ticketmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketmanagement.R;
import com.example.ticketmanagement.model.Order;

import java.util.ArrayList;

public class OrderRecViewAdapter extends RecyclerView.Adapter<OrderRecViewAdapter.ViewHolder> {
    private ArrayList<Order> orderArrayList = new ArrayList<>();
    private Context context;
    public OrderRecViewAdapter(Context context){this.context = context;}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.order_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.orderId.setText("OrderId: "+orderArrayList.get(position).getOrderId().toString());
        holder.ordredAt.setText("Ordered At: " + orderArrayList.get(position).returnDate());
        holder.ticketCategoryDescription.setText("Ticket Type: "+orderArrayList.get(position).getTicketCategoryDescription());
        holder.numberOfTickets.setText("Number of tickets: " + String.valueOf(orderArrayList.get(position).getNumberOfTickets()));
        holder.price.setText("Total price: "+orderArrayList.get(position).getTotalPrice().toString());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context,"OrderId: " + orderArrayList.get(position).getOrderId().toString()+" Selected",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {return orderArrayList.size();}

    public void setOrderArrayList(ArrayList<Order> orderArrayList){
        this.orderArrayList=orderArrayList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView orderId,ordredAt,ticketCategoryDescription,
                numberOfTickets,price;
        private CardView parent;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            orderId = itemView.findViewById(R.id.orderId);
            ordredAt= itemView.findViewById(R.id.orderdAt);
            ticketCategoryDescription = itemView.findViewById(R.id.ticketCategoryDescription);
            numberOfTickets = itemView.findViewById(R.id.numberOfTickets);
            price = itemView.findViewById(R.id.price);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
