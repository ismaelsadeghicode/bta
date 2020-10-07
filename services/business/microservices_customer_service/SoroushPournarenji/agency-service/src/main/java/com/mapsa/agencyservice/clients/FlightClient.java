package com.mapsa.agencyservice.clients;

import com.mapsa.agencyservice.data.Flight;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "Web",url = "http://soroush02.herokuapp.com/flight")
public interface FlightClient {
    @GetMapping
    List<Flight> flightList();

    @GetMapping("/{id}")
    Optional<Flight> findById(Long id);

    @PostMapping
    void save(Flight flight);

    @PatchMapping
    void update(Flight flight);

    @DeleteMapping
    void delete(Flight flight);

    @PutMapping
     void updateOrSave(Flight flight);
}
