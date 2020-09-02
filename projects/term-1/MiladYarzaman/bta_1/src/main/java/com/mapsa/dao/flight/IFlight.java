package com.mapsa.dao.flight;

import com.mapsa.models.Flight;

import java.sql.Date;
import java.util.List;

public interface IFlight {
    long createFlight(Flight flight);
    List<Flight> getFlightList();
    Flight getFlightById(long flightId);
    boolean deleteFlightById(long id);
    boolean updateFlight(Flight flight);
    List<Flight> getFlightByDestination(String destination);
    List<Flight> getFlightByDestinationAndDate(String destination, Date date);
    List<Flight> getFlightByDestinationAndSource(String destination, String Source);
}
