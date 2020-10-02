package com.mapsa.airline.service;

import com.mapsa.airline.domin.Flight;
import com.mapsa.airline.repository.FlightRepository;
import lombok.RequiredArgsConstructor;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class FlightService {
    private final FlightRepository flightRepository;

    public List<Flight> findAllFlightList() {
        return flightRepository.findAll();
    }

    public void save(Flight flight) throws Exception {
        if (flight.getId() == null) {
            flightRepository.save(flight);
        }else {
          throw new Exception("Do not enter a id");
        }
    }

    public void updateOrSave(Flight flight) {
        Flight dbFlight = flightRepository.findById(flight.getId()).orElse(new Flight());
        Flight flight1 = whichFieldToChange(flight, dbFlight);
        flightRepository.save(flight1);
    }

    public void delete(Flight flight) {
        flightRepository.delete(flight);
    }

    public Optional<Flight> findFlightById(Long id) {
        return flightRepository.findById(id);
    }

    public void update(Flight flight) throws Exception {
        Flight dbFlight = flightRepository.findById(flight.getId()).orElseThrow(() -> new Exception("Resource Not found"));
        flightRepository.save(whichFieldToChange(flight, dbFlight));
    }

    /**
     * Which field to change
     *
     * @param flight  new field(from Dispatcher Servlet)
     * @param flight1 old field(from DataBase or  new)
     * @return field changed
     */
    private Flight whichFieldToChange(Flight flight, Flight flight1) {
        if (flight.getCompany() != null) {
            flight1.setCompany(flight.getCompany());
        }
        if (flight.getDestination() != null) {
            flight1.setDestination(flight.getDestination());
        }
        if (flight.getOrigin() != null) {
            flight1.setOrigin(flight.getOrigin());
        }
        if (flight.getQuantity() != null) {
            flight1.setQuantity(flight.getQuantity());
        }
        if (flight.getFee() != null) {
            flight1.setFee(flight.getFee());
        }
        if (flight.getDescription() != null) {
            flight1.setDescription(flight.getDescription());
        }
        return flight1;
    }
}
