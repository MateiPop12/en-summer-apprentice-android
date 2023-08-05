package com.example.ticketmanagement.model;

public class Event {
    private String eventName;
    private String eventDescription;
    private String venueLocation;
    private String eventStartDate;
    private String eventEndDate;
    private int imageUrl;

    public Event(String name, String description, String startDate, String endDate, String venueLocation, int imageUrl) {
        this.eventName = name;
        this.eventDescription = description;
        this.eventStartDate = startDate;
        this.eventEndDate = endDate;
        this.venueLocation = venueLocation;
        this.imageUrl = imageUrl;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDescription() {
        return eventDescription;
    }

    public void setEventDescription(String eventDescription) {
        this.eventDescription = eventDescription;
    }

    public String getEventStartDate() {
        return eventStartDate;
    }

    public void setEventStartDate(String eventStartDate) {this.eventStartDate = eventStartDate;}

    public String getEventEndDate() {
        return eventEndDate;
    }

    public void setEventEndDate(String eventEndDate) {
        this.eventEndDate = eventEndDate;
    }
    public String getVenueLocation() {return venueLocation;}

    public void setVenueLocation(String venueLocation) {this.venueLocation = venueLocation;}

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }


    @Override
    public String toString() {
        return "Event{" +
                "name='" + eventName + '\'' +
                ", description='" + eventDescription + '\'' +
                ", venueLocation='" + venueLocation + '\'' +
                ", startDate=" + eventStartDate +
                ", endDate=" + eventEndDate +
                ", imageUrl=" + imageUrl +
                '}';
    }
}
