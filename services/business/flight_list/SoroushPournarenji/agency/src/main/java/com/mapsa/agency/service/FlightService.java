package com.mapsa.agency.service;

import com.mapsa.agency.client.FlightClientImpl;
import com.mapsa.agency.data.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class FlightService {

    private final FlightClientImpl flightClient;

    public List<Flight> findAllFlight(){
        List<Flight> flights=flightClient.findAllFlight();
        return flights;
    }
    public Flight  findFlightById(Long id){
        if(id !=null && id>0){
            return flightClient.findFlightById(id);
        }
        return null;
    }
}
