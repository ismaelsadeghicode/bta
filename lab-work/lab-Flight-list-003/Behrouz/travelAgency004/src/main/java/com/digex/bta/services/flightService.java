package com.digex.bta.services;


import com.digex.bta.model.flightDto;
import com.sun.org.apache.xalan.internal.lib.ExsltDatetime;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
@Component
public class flightService {

    List<flightDto> flights = new ArrayList<>() ;

    public List<flightDto> getAllFlights () {
        flightDto flightDto = new flightDto() ;
        flightDto.setFlightId(23);
        flightDto.setOrigin("iran");
        flightDto.setDestination("canada");
        flightDto.setTime(Time.valueOf(LocalTime.now()));
        flightDto.setUnitInStock(3);

        flightDto flightDto2 = new flightDto() ;

        flightDto2.setFlightId(23);
        flightDto2.setOrigin("sdfsf");
        flightDto2.setDestination("sdfsdf");
        flightDto2.setTime(Time.valueOf(LocalTime.now()));
        flightDto2.setUnitInStock(32);

        flights.add(flightDto) ;
        flights.add(flightDto2) ;
        return flights ;
    }

    public boolean deleteFlight(int flightId) {
    return false ;
    }

    public boolean updateFlight(int flightId) {
        return false ;
    }

    public boolean addFlight(flightDto flightDto) {
        return false ;
    }



}
