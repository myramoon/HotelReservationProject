package com.hotelreservationproject;
import java.text.SimpleDateFormat;
import java.util.*;

public class HotelReservation {

    Hotel addHotel(String name , String type , int weekday) {
        return new Hotel(name , type , weekday);
    }

    public Result findCheapestHotel(ArrayList<Hotel> hotelArray , String dateS , String dateE) {  //returns calculated cheapest hotel
        int daysInBetween = getDaysInBetween(dateS , dateE);
        return getCheapestHotel(daysInBetween , hotelArray);
    }

    private static int getDaysInBetween(String dateS , String dateE){ //finds days in between

        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        Date dateStart = new Date();
        try {
            dateStart = formatter.parse(dateS);
        } catch (Exception e) {
            System.out.println("Please enter proper starting date");
        }
        Date dateEnd = new Date();
        try {
            dateEnd = formatter.parse(dateE);
        } catch (Exception e) {
            System.out.println("Please enter proper ending date");
        }

        long difference = dateEnd.getTime() - dateStart.getTime();
        return (int) Math.ceil(difference / (1000 * 60 * 60 * 24));
    }

    private static Result getCheapestHotel(int daysInBetween , ArrayList<Hotel> hotelArray) throws NoSuchElementException { //calculates cheapest hotel and returns its details
        int currentHotelCost;
            for (Hotel currentHotel : hotelArray) {     // set weekday cost for each hotel
                currentHotelCost = daysInBetween * currentHotel.getWeekdayRate();
                currentHotel.setCostWeekDay(currentHotelCost);
            }
        Optional<Hotel> cheapestHotel = hotelArray.stream().min(Comparator.comparing(Hotel::getCostWeekday));
        Result result = new Result();
        result.setHotelName(cheapestHotel.get().getHotelName());
        result.setTotalCost(cheapestHotel.get().getCostWeekday());
        return result;
    }
}


