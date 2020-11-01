package com.hotelreservationproject;

public class Hotel {
    private String hotelName;
    private String typeOfCustomer;
    private int weekdayRate;
    private int weekendRate;
    public int costWeekday;

    public Hotel(String hotelName, String typeOfCustomer, int weekdayRate , int weekendRate) {
        this.hotelName = hotelName;
        this.typeOfCustomer = typeOfCustomer;
        this.weekdayRate = weekdayRate;
        this.weekendRate = weekendRate;
    }

    public String getHotelName() {
        return hotelName;
    }

    public String getTypeOfCustomer() {
        return typeOfCustomer;
    }

    public int getWeekdayRate() {
        return weekdayRate;
    }

    public int getWeekendRate() {
        return weekendRate;
    }

    public int getCostWeekday() {
        return  costWeekday;
    }

    public void setCostWeekDay(int costWeekday) {
        this.costWeekday = costWeekday;
    }
}
