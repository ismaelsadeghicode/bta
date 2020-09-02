package com.mapsa.service;

import com.mapsa.dao.FlightDao;
import com.mapsa.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightDao flightDao;

    public List<Flight> flightList() {
        List<Flight> flights = flightDao.findAllFlight();
        return flights;
    }
    public Flight getFlightById(long id){
        return flightDao.getFlightById(id);
    }

    public List<Flight> addFlight(Flight flight) {
        flightDao.addFlight(flight);
        return flightList();
    }

    public List<Flight> deleteFlight(Flight flight) {
        flightDao.deleteFlight(flight);
        return flightList();
    }

    public List<Flight> updateFlight(Flight flight) {
        flightDao.editFlight(flight);
        return flightList();
    }

    public List<Flight> patchFlight(Flight flight) {
        updateFlight(check(flight));
        return flightList();
    }

    private Flight check(Flight flight) {
        Flight oldFlight = flightDao.getFlightById(flight.getId());
        if (flight.getName() != null) {
            oldFlight.setName(flight.getName());
        }
        if (flight.getCompany() != null) {
            oldFlight.setCompany(flight.getCompany());
        }
        if (flight.getArrivalDate() != null) {
            oldFlight.setArrivalDate(flight.getArrivalDate());
        }
        if (flight.getDescription() != null) {
            oldFlight.setDescription(flight.getDescription());
        }
        if (flight.getDestination() != null) {
            oldFlight.setDestination(flight.getDestination());
        }
        if (flight.getFee() != null) {
            oldFlight.setFee(flight.getFee());
        }
        if (flight.getFlightDate() != null) {
            oldFlight.setFlightDate(flight.getFlightDate());
        }
        if (flight.getOrigin() != null) {
            oldFlight.setOrigin(flight.getOrigin());
        }
        if (flight.getQuantity() != null) {
            oldFlight.setQuantity(flight.getQuantity());
        }
        return oldFlight;
    }
}
