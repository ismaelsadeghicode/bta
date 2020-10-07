package com.mapsa.agencyservice.controller;

import com.mapsa.agencyservice.data.Flight;
import com.mapsa.agencyservice.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<Optional<Flight>> findFlightById(@PathVariable Long id) {
       Optional<Flight> flight=flightService.findFlightById(id);
        if (flight !=null) {
            return ResponseEntity.ok(flight);
        }
        return ResponseEntity.badRequest().build();
    }


    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save( @RequestBody Flight flight) throws Exception {
        flightService.save(flight);
    }


    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void updateOrSave( @RequestBody Flight flight) {
        flightService.updateOrSave(flight);
    }


    @PatchMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void update(@RequestBody Flight flight) throws Exception {
        flightService.update(flight);

    }

    @DeleteMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void delete(@RequestBody Flight flight) {
        flightService.delete(flight);
    }

}
