package com.hotelreservationproject;

import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class HotelReservationTest {

    //Tests for verifying added hotel details
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
    //Tests for verifying cheapest hotel details
    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelName() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<Hotel> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 ));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 ));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 ));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"2020-09-11" , "2020-09-12");
        Assert.assertEquals("Lakewood" , cheapestHotel.getHotelName());
    }

    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRateOnBasisOfWeekdays() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<Hotel> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 ));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 ));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150  ));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray,"2020-09-11" , "2020-09-12");
        Assert.assertTrue(cheapestHotel.getTotalCost().equals(200));
    }
    //Tests for verifying entered weekday and weekend rates for a hotel
    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekdayRate() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel hotel1 = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        Hotel hotel2 = hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 );
        Hotel hotel3 = hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 );
        Assert.assertTrue(hotel3.getWeekdayRate().equals(220));
    }

    @Test
    public void givenHotelDetails_WhenAddedForHotel_ShouldReturnEnteredWeekendRate() {
        HotelReservation hotelReservation = new HotelReservation();
        Hotel hotel1 = hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 );
        Hotel hotel2 = hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 );
        Hotel hotel3 = hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150 );
        Assert.assertTrue(hotel2.getWeekendRate().equals(50));
    }
    //Tests for verifying cheapest hotel details taking weekday and weekend rates into account
    @Test
    public void givenDateRange_WhenAddedForHotel_ShouldReturnCheapestHotelRateOnBasisOfWeekdaysAndWeekends() {
        HotelReservation hotelReservation = new HotelReservation();
        ArrayList<Hotel> hotelArray = new ArrayList<>();
        hotelArray.add(hotelReservation.addHotel("Lakewood" , "Normal" , 110 , 90 ));
        hotelArray.add(hotelReservation.addHotel("Bridgewood" , "Normal" , 160 , 50 ));
        hotelArray.add(hotelReservation.addHotel("Ridgewood" , "Normal" , 220 , 150  ));
        Result cheapestHotel = hotelReservation.findCheapestHotel(hotelArray , "2020-09-11" , "2020-09-14");
        Assert.assertEquals("Lakewood" , cheapestHotel.getHotelName());
    }
}
