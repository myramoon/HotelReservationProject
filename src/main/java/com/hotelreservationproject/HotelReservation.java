package com.hotelreservationproject;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class HotelReservation {

    Hotel addHotel(String name , String type , Integer weekdayRate , Integer weekendRate , Integer rating) { //add hotel
        return new Hotel(name , type , weekdayRate , weekendRate , rating);
    }

    public Result findCheapestHotel(ArrayList<Hotel> hotelArray , String dateS , String dateE) {  //gets total cost for each hotel and returns cheapest and best rated hotel

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
        Result result = this.getCheapestHotel(hotelArray);
        result = this.cheapestBestRatedHotel(hotelArray , result);
        return result;
    }

    public Result getCheapestHotel(ArrayList<Hotel> hotelArray){ //compares total costs of hotels

        Optional<Hotel> cheapestHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Result result = new Result();
        result.setHotelName(cheapestHotel.get().getHotelName());
        result.setTotalCost(cheapestHotel.get().getTotalCost());
        return result;
    }

    public Result cheapestBestRatedHotel(ArrayList<Hotel> hotelArray , Result result) {  //finds cheapest and best rated hotel
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
}





