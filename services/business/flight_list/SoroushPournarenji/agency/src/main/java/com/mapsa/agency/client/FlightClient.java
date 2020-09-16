package com.mapsa.agency.client;

import com.mapsa.agency.data.Flight;

import java.util.List;

public interface FlightClient {

    List<Flight> findAllFlight();
    Flight findFlightById(Long id);
}
