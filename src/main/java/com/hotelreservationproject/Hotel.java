package com.hotelreservationproject;

public class Hotel {
    String hotelName;
    String typeOfCustomer;
    int weekdayRate;
    int weekendRate;

    public Hotel(String hotelName, String typeOfCustomer, int weekdayRate, int weekendRate) {
        this.hotelName = hotelName;
        this.typeOfCustomer = typeOfCustomer;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }
}
