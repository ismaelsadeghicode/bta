package com.mapsa.agencyservice.service;

import com.mapsa.agencyservice.clients.FlightClient;
import com.mapsa.agencyservice.data.Flight;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor_ = @Autowired)
@Service
public class FlightService {

    private final FlightClient flightClient;

    public List<Flight> findAllFlight(){
        List<Flight> flights=flightClient.flightList();
        return flights;
    }
    public Optional<Flight>  findFlightById(Long id){
        if(id !=null && id>0){
            return flightClient.findById(id);
        }
        return null;
    }

    public void save(Flight flight) {
         flightClient.save(flight);
    }

    public void updateOrSave(Flight flight) {
        flightClient.updateOrSave(flight);
    }

    public void update(Flight flight) {
        flightClient.update(flight);
    }

    public void delete(Flight flight) {
        flightClient.delete(flight);
    }
}
