package com.hotelreservationproject;

public class Result {
    String hotelName;
    Integer totalCost;
    Integer rating;

    public String getHotelName() {
        return hotelName;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public Integer getRating() {
        return rating;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
