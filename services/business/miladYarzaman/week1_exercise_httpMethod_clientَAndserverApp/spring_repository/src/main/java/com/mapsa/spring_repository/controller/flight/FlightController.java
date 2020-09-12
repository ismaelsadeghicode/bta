package com.mapsa.spring_repository.controller.flight;

import com.mapsa.spring_repository.data.flight.SearchFlightDto;
import com.mapsa.spring_repository.domain.Flight;
import com.mapsa.spring_repository.repository.flight.FlightRepository;
import com.mapsa.spring_repository.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class FlightController {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    FlightService flightService;
    @GetMapping
    public ResponseEntity<List<Flight>> flights(){

        return ResponseEntity.ok(flightRepository.findAll());
    }
    @PostMapping
    public ResponseEntity<Flight> save(@RequestBody Flight flight){

        return ResponseEntity.ok(flightRepository.save(flight));
    }
    @PostMapping("searchFlights")
    public ResponseEntity<List<Flight>> getFlightsByDesAndSrc(@RequestBody SearchFlightDto searchFlightDto){
      return ResponseEntity.ok(flightService.getFlightsByDesAndSrc(searchFlightDto));
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        flightRepository.deleteById(id);

    }
    @PutMapping
    public ResponseEntity<Flight> putUpdate(@RequestBody Flight flight){

        return ResponseEntity.ok(flightService.putUpdate(flight));
    }
    @PatchMapping
    public ResponseEntity<Flight> patchUpdate(@RequestBody Flight flight){

        return ResponseEntity.ok(flightService.patchUpdate(flight));
    }

}
