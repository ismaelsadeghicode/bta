package com.mapsa.agency.client;

import com.mapsa.agency.data.Flight;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@Component
public class FlightClientImpl implements FlightClient {
    @Value("${airline.flight}")
    String uri =null ;
    @Override
    public List<Flight> findAllFlight() {
        RestTemplate restTemplate=new RestTemplate();
        Flight[] flights= restTemplate.getForObject(uri, Flight[].class);
        List<Flight> flightList= Arrays.asList(flights);
        return flightList;
    }

    @Override
    public Flight findFlightById(Long id) {
        List<Flight> flights=findAllFlight();
        for (Flight flight:flights) {
            if(flight.getId()==id){
                return flight;
            }
        }
        return null;
    }
}
