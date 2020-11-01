package com.hotelreservationproject;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class HotelReservation {

    public Hotel addHotel(String name , String type , Integer weekdayRate , Integer weekendRate , Integer rating) { //add hotel
        return new Hotel(name , type , weekdayRate , weekendRate , rating);
    }

    public void setCost(ArrayList<Hotel> hotelArray , String dateS , String dateE) {  //gets total cost for each hotel and returns cheapest and best rated hotel

        Integer cost;
        LocalDate dateStart = null , dateEnd = null;

        try {
            dateStart = LocalDate.parse(dateS);
        } catch (Exception e) {
            System.out.println("Please enter proper starting date");
        }
        try {
            dateEnd = LocalDate.parse(dateE);
        } catch (Exception e) {
            System.out.println("Please enter proper ending date");
        }
        long difference = Duration.between(dateStart.atStartOfDay() , dateEnd.atStartOfDay()).toDays();

        for(Hotel hotel : hotelArray) {
            cost = hotel.getTotalRate(dateStart, dateEnd, difference);
            hotel.setTotalCost(cost);
        }
    }


    public Result getCheapestHotel(ArrayList<Hotel> hotelArray , String dateS , String dateE){ //compares total costs of hotels

        this.setCost(hotelArray , dateS , dateE);
        Optional<Hotel> cheapestHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Result result = new Result();
        result.setHotelName(cheapestHotel.get().getHotelName());
        result.setTotalCost(cheapestHotel.get().getTotalCost());
        return result;
    }

    public Result findCheapestBestRatedHotel(ArrayList<Hotel> hotelArray , String dateS ,String dateE) {  //finds cheapest and best rated hotel

        Result result;
        result = this.getCheapestHotel(hotelArray , dateS , dateE);
        Optional<Hotel> maxCostHotel = hotelArray.stream().max(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Optional<Hotel> minRatingHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getRating()));
        for (Hotel hotel : hotelArray) {
            if (hotel.getTotalCost() < maxCostHotel.get().getTotalCost() && hotel.getRating() > minRatingHotel.get().getRating()) {
                result.setRating(hotel.getRating());
                result.setHotelName(hotel.getHotelName());
                result.setTotalCost(hotel.getTotalCost());
            }
        }
        return result;
    }

    public Result findBestRatedHotel(ArrayList<Hotel> hotelArray , String dateS , String dateE) { //returns best rated hotel for a date range

        Result result = new Result();
        this.setCost(hotelArray , dateS , dateE);
        Optional<Hotel> maxRatingHotel = hotelArray.stream().max(Comparator.comparingInt(hotel -> hotel.getRating()));
        result.setHotelName(maxRatingHotel.get().getHotelName());
        result.setTotalCost(maxRatingHotel.get().getTotalCost());
        result.setRating(maxRatingHotel.get().getRating());
        return result;
    }
}





