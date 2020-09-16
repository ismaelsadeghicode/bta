package com.mapsa.airline.controller;

import com.mapsa.airline.domin.Flight;
import com.mapsa.airline.repository.FlightRepository;
import com.mapsa.airline.service.FlightService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@RequestMapping("flight")
public class FlightController {

    private final FlightService flightService;

    @GetMapping
    public ResponseEntity<List<Flight>> flightList() {
        return ResponseEntity.ok(flightService.findAllFlightList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Flight>> findById(@PathVariable Long id) {
        return ResponseEntity.ok(flightService.findFlightById(id));
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void save(@Valid @RequestBody Flight flight) throws Exception {
        flightService.save(flight);
    }


    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void updateOrSave(@Valid @RequestBody Flight flight) {
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

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    @RequestMapping(method = RequestMethod.OPTIONS)
    public ResponseEntity<?> options()
    {
        return ResponseEntity
                .ok()
                .allow(HttpMethod.GET,HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.OPTIONS)
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String Exceptions(
            Exception ex) {

        return ex.getMessage();
    }
}