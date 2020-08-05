package com.test.services;

import com.test.model.Flight;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {
    public List<Flight> flightList ;
    public List<Flight> flights(){
        Flight flightOne=new Flight();
        flightOne.setFlightId(1l);
        flightOne.setFlightName("A");
        flightOne.setDescription("First Class");
        flightOne.setUnitPrice("7000000");
        flightOne.setStatus(true);
        flightOne.setFrom("Tehran");
        flightOne.setTo("Shiraz");
        flightOne.setUnitInStock(4);
        Flight flightTwo=new Flight();
        flightTwo.setFlightId(2l);
        flightTwo.setFlightName("B");
        flightTwo.setDescription("First Class");
        flightTwo.setFrom("Tehran");
        flightTwo.setTo("Kish");
        flightTwo.setUnitPrice("9000000");
        flightTwo.setStatus(false);
        flightTwo.setUnitInStock(0);
        Flight flightThree=new Flight();
        flightThree.setFlightId(3l);
        flightThree.setFlightName("C");
        flightThree.setDescription("Business class");
        flightThree.setFrom("Tehran");
        flightThree.setTo("Tabriz");
        flightThree.setUnitPrice("5000000");
        flightThree.setStatus(true);
        flightThree.setUnitInStock(3);
        Flight flightFour=new Flight();
        flightFour.setFlightId(4l);
        flightFour.setFlightName("D");
        flightFour.setDescription("Economy class");
        flightFour.setFrom("Tehran");
        flightFour.setTo("Mashhad");
        flightFour.setUnitPrice("2000000");
        flightFour.setStatus(false);
        flightFour.setUnitInStock(0);

        flightList=new ArrayList<>();
        flightList.add(flightOne);
        flightList.add(flightTwo);
        flightList.add(flightThree);
        flightList.add(flightFour);

        return flightList;
    }
    public Flight getFlightById(Long id) throws IOException {
        for (Flight flight:flights( )) {
            if(flight.getFlightId() == id){
                return flight;
            }
        }
        throw new IOException("No flight fund");
    }
}
