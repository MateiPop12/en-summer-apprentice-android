package com.example.ticketmanagement;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ticketmanagement.activity.RecyclerViewInterface;
import com.example.ticketmanagement.adapter.EventRecViewAdapter;
import com.example.ticketmanagement.adapter.OrderRecViewAdapter;
import com.example.ticketmanagement.model.Event;
import com.example.ticketmanagement.model.Order;
import com.example.ticketmanagement.retrofit.EventApi;
import com.example.ticketmanagement.retrofit.RetrofitService;

import java.time.LocalDateTime;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    private RecyclerView eventRecView;
    private RecyclerView orderRecView;
    private Button eventButton;
    private Button orderButton;
    private SearchView searchView;
    private RetrofitService retrofitService;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        retrofitService = new RetrofitService();
        eventRecView = findViewById(R.id.eventRecView);
        orderRecView = findViewById(R.id.orderRecView);
        eventButton = findViewById(R.id.btnEvents);
        orderButton = findViewById(R.id.btnOrders);
        searchView = findViewById(R.id.searchBar);

        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderRecView.setVisibility(View.VISIBLE);
                eventRecView.setVisibility(View.GONE);
                orderButton.setVisibility(View.GONE);
                eventButton.setVisibility(View.VISIBLE);
            }
        });

        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderRecView.setVisibility(View.GONE);
                eventRecView.setVisibility(View.VISIBLE);
                eventButton.setVisibility(View.GONE);
                orderButton.setVisibility(View.VISIBLE);
            }
        });

        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eventButton.setVisibility(View.GONE);
            }
        });

        ArrayList<Event> events = new ArrayList<>();
        events.add(new Event("Nespusul","Muzică electronică", LocalDateTime.now().toString(),LocalDateTime.now().plusDays(5).toString(),"Stadion",R.drawable.le9nn8mhokh_3o));
        events.add(new Event("Opănhaimăr","Film", LocalDateTime.now().toString(),LocalDateTime.now().plusDays(1).toString(),"Cinema",R.drawable.ic_launcher_background));

        ArrayList<Order> orders =new ArrayList<>();
        orders.add(new Order(1L,LocalDateTime.now(),"Vip",3, 550.45F));
        orders.add(new Order(2L,LocalDateTime.now(),"Standard",2, 60.15F));

        EventRecViewAdapter adapter1 = new EventRecViewAdapter(this,this);
        OrderRecViewAdapter adapter2 = new OrderRecViewAdapter(this);

//        adapter1.setEventArrayList(events);
        adapter2.setOrderArrayList(orders);

//        eventRecView.setAdapter(adapter1);
        orderRecView.setAdapter(adapter2);

//        eventRecView.setLayoutManager(new LinearLayoutManager(this));
        orderRecView.setLayoutManager(new LinearLayoutManager(this));

        fetchEventsFromServer(adapter1);
    }
    private void fetchEventsFromServer(EventRecViewAdapter adapter){
        EventApi eventApi = retrofitService.getRetrofit().create(EventApi.class);
        Call<ArrayList<Event>> call = eventApi.getAllEvents();

        call.enqueue(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Event> events = response.body();
                    if (events != null) {
                        //EventRecViewAdapter adapter = new EventRecViewAdapter(MainActivity.this,MainActivity.this);
                        Log.d("MainActivity", "Received " + events.size());
                        adapter.setEventArrayList(events);
                        eventRecView.setAdapter(adapter);
                        eventRecView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    }
                } else {
                    // Handle unsuccessful response here
                    Log.d("MainActivity", "Response body is null!");
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failed to load events", Toast.LENGTH_SHORT).show();
                Log.d("MainActivity", t.toString());
            }
        });
    }
    @Override
    public void onItemClick(Event event) {
        //Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this,MainActivity2.class);
        startActivity(intent);
    }
}
