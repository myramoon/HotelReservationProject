package com.hotelreservationproject;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;

public class HotelReservation{

    Hotel addHotel(String name , String type , Integer weekdayRate , Integer weekendRate , Integer rating) { //add hotel
        return new Hotel(name , type , weekdayRate , weekendRate , rating);
    }

    public Result findCheapestHotel(ArrayList<Hotel> hotelArray , String dateS , String dateE) {  //gets total cost for each hotel and returns cheapest hotel

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
        return this.getCheapestHotel(hotelArray);
    }

    public Result getCheapestHotel(ArrayList<Hotel> hotelArray){ //compares total costs of hotels
        Optional<Hotel> cheapestHotel = hotelArray.stream().min(Comparator.comparingInt(hotel -> hotel.getTotalCost()));
        Result result = new Result();
        result.setHotelName(cheapestHotel.get().getHotelName());
        result.setTotalCost(cheapestHotel.get().getTotalCost());
        System.out.println(result.getHotelName() + result.getTotalCost());
        return result;
    }

}


