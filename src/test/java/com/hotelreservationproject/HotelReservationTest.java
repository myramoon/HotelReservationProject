package com.hotelreservationproject;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class HotelReservationTest {
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90);
        Assert.assertEquals(newHotel.getHotelName() , "Lakewood");
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredCustomerType() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        Assert.assertEquals(newHotel.getTypeOfCustomer() , "Normal");
    }

    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelName() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<Hotel> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 ));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 ));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 ));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"10092020" , "12092020");
        Assert.assertEquals("Lakewood" , cheapestHotel.getHotelName() );
    }

    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRate() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<Hotel> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 ));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 ));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150  ));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"10092020" , "12092020");
        Assert.assertEquals(220 , cheapestHotel.getTotalCost());
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel hotel1 = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        Hotel hotel2 = hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 );
        Hotel hotel3 = hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 );
        Assert.assertEquals(220 , hotel3.getWeekdayRate());
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShoulReturnEnteredWeekendRate() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel hotel1 = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        Hotel hotel2 = hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 );
        Hotel hotel3 = hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 );
        Assert.assertEquals(50 , hotel2.getWeekendRate());
    }
}
