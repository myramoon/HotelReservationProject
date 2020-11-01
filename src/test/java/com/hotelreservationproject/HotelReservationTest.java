package com.hotelreservationproject;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class HotelReservationTest {

    //Tests for verifying added hotel details
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredName() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3);
        Assert.assertEquals(newHotel.getHotelName() , "Lakewood");
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredCustomerType() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3 );
        Assert.assertEquals(newHotel.getTypeOfCustomer() , "Normal");
    }

    //Tests for verifying entered weekday and weekend rates for a hotel
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel hotel1 = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3);
        Hotel hotel2 = hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 , 4);
        Hotel hotel3 = hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 , 5);
        Assert.assertTrue(hotel3.getWeekdayRate().equals(220));
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekendRate() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel hotel1 = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3);
        Hotel hotel2 = hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 ,4);
        Hotel hotel3 = hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 , 5);
        Assert.assertTrue(hotel2.getWeekendRate().equals(50));
    }

    //Test for verifying hotel rating
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredRating() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel newHotel = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3);
        Assert.assertTrue(newHotel.getRating().equals(3));
    }

    //Tests for verifying cheapest and best rated hotel
    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRateOnBasisOfCostAndRating() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<Hotel> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 , 3));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 , 4));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150  , 5));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray , "2020-09-11" , "2020-09-12");
        Assert.assertEquals("Bridgewood" , cheapestHotel.getHotelName());
    }
}
