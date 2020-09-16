package com.mapsa.agency.controller;

import com.mapsa.agency.data.Flight;
import com.mapsa.agency.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("/")
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> findAllFlight() {
        return ResponseEntity.ok(flightService.findAllFlight());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> findFlightById(@PathVariable Long id) {
       Flight flight=flightService.findFlightById(id);
        if (flight!=null) {
            return ResponseEntity.ok(flight);
        }
        return ResponseEntity.badRequest().build();
    }
}
