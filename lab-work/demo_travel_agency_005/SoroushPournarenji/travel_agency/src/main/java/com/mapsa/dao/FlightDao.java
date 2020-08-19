package com.mapsa.dao;

import com.mapsa.model.Flight;

import java.util.List;

public interface FlightDao {
    List<Flight> findAllFlight();
    Flight getFlightById(long id);
    void addFlight(Flight flight);
    void editFlight(Flight flight);
    void deleteFlight(Flight flight);

}
