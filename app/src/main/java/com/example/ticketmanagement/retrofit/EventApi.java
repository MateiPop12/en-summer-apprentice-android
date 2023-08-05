package com.example.ticketmanagement.retrofit;

import com.example.ticketmanagement.model.Event;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface EventApi {
    @GET("/event/all") // Replace "events" with the actual endpoint for getting events from the backend
    Call<ArrayList<Event>> getAllEvents();
}
