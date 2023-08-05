package com.example.ticketmanagement.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketmanagement.R;
import com.example.ticketmanagement.activity.RecyclerViewInterface;
import com.example.ticketmanagement.model.Event;

import java.util.ArrayList;

public class EventRecViewAdapter extends RecyclerView.Adapter<EventRecViewAdapter.ViewHolder>{
    private ArrayList<Event> eventArrayList = new ArrayList<>();
    private final Context context;
    private final RecyclerViewInterface recyclerViewInterface;
    public EventRecViewAdapter(Context context,RecyclerViewInterface recyclerViewInterface) {
        this. context = context;
        this.recyclerViewInterface = recyclerViewInterface;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.events_list_item,parent,false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder,int position) {
        holder.eventTitle.setText(eventArrayList.get(position).getEventName());
        holder.eventDescription.setText(eventArrayList.get(position).getEventDescription());
        holder.eventVenueLocation.setText(eventArrayList.get(position).getVenueLocation());
        holder.eventStartDate.setText("Starts: " + eventArrayList.get(position).getEventStartDate());
        holder.eventEndDate.setText("Ends: " + eventArrayList.get(position).getEventEndDate());
        holder.imageView.setImageResource(eventArrayList.get(position).getImageUrl());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recyclerViewInterface.onItemClick(eventArrayList.get(position));
            }
        });
    }
    @Override
    public int getItemCount() {
        return eventArrayList.size();
    }

    public void setEventArrayList(ArrayList<Event> eventArrayList) {
        this.eventArrayList = eventArrayList;
        notifyDataSetChanged();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView eventTitle,eventDescription,eventStartDate,eventEndDate,eventVenueLocation;
        private final ImageView imageView;
        private final CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            eventTitle = itemView.findViewById(R.id.eventName);
            eventDescription = itemView.findViewById(R.id.eventDescription);
            eventVenueLocation = itemView.findViewById(R.id.eventVenueLocation);
            eventStartDate = itemView.findViewById(R.id.eventStartDate);
            eventEndDate = itemView.findViewById(R.id.eventEndDate);
            imageView = itemView.findViewById(R.id.image);
            cardView = itemView.findViewById(R.id.eventParent);
        }
    }
}
