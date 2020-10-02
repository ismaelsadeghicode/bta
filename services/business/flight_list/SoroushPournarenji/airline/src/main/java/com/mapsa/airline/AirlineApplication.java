package com.mapsa.airline;

import com.mapsa.airline.domin.Flight;
import com.mapsa.airline.repository.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AirlineApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AirlineApplication.class, args);
    }
    @Autowired
    FlightRepository flightRepository;

    @Override
    public void run(String... args) throws Exception {
        flightRepository.saveAll(exampleFlightList());
    }
    private List<Flight> exampleFlightList(){
        List<Flight> flights=new ArrayList<>();
        flights.add( Flight.builder()
                .company("AirLine").origin("Tabriz").destination("Shiraz").fee(800000l).quantity(15).description("A")
                .build());
        flights.add( Flight.builder()
                .company("AirLine").origin("Kish").destination("Tehran").fee(950000l).quantity(1).description("B")
                .build());
        flights.add( Flight.builder()
                .company("AirLine").origin("Tehran").destination("Yazd").fee(850000l).quantity(9).description("C")
                .build());
        return flights;
    }

}
