package com.example.ticketmanagement.model;

import java.time.LocalDateTime;
import java.time.temporal.ChronoField;

public class Order {
    private Long orderId;
    private LocalDateTime orderedAt;
    private String ticketCategoryDescription;
    private int numberOfTickets;
    private Float totalPrice;

    public Order(Long orderId, LocalDateTime orderedAt, String ticketCategoryDescription, int numberOfTickets, Float totalPrice) {
        this.orderId = orderId;
        this.orderedAt = orderedAt;
        this.ticketCategoryDescription = ticketCategoryDescription;
        this.numberOfTickets = numberOfTickets;
        this.totalPrice = totalPrice;
    }

    public Long getOrderId() {return orderId;}
    public String returnOrderId(){return orderId.toString();}
    public void setOrderId(Long orderId) {this.orderId = orderId;}
    public LocalDateTime getOrderedAt() {return orderedAt;}
    public void setOrderedAt(LocalDateTime orderedAt) {this.orderedAt = orderedAt;}
    public String getTicketCategoryDescription() {return ticketCategoryDescription;}
    public void setTicketCategoryDescription(String ticketCategoryDescription) {this.ticketCategoryDescription = ticketCategoryDescription;}
    public int getNumberOfTickets() {return numberOfTickets;}
    public void setNumberOfTickets(int numberOfTickets) {this.numberOfTickets = numberOfTickets;}
    public Float getTotalPrice() {return totalPrice;}
    public void setTotalPrice(Float totalPrice) {this.totalPrice = totalPrice;}
    public String returnDate(){
        return orderedAt.get(ChronoField.DAY_OF_MONTH)+"/"
                +orderedAt.get(ChronoField.MONTH_OF_YEAR)+"/"
                +orderedAt.get(ChronoField.YEAR)+"-"
                +orderedAt.get(ChronoField.HOUR_OF_DAY)+":"
                +orderedAt.get(ChronoField.MINUTE_OF_HOUR);
    }
    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderedAt=" + orderedAt +
                ", ticketCategoryDescription='" + ticketCategoryDescription + '\'' +
                ", numberOfTickets=" + numberOfTickets +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
