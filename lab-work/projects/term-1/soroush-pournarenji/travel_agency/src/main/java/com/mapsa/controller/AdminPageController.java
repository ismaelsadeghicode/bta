package com.mapsa.controller;

import com.mapsa.model.Flight;
import com.mapsa.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/flight")
public class AdminPageController {
    @Autowired
    FlightService flightService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Flight> flightList() {
        return flightService.flightList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody
    List<Flight> addFlight(@RequestBody Flight flight) {
        return flightService.addFlight(flight);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public @ResponseBody
    List<Flight> deleteFlight(@RequestBody Flight flight) {
        return flightService.deleteFlight(flight);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public @ResponseBody
    List<Flight> putFlight(@RequestBody Flight flight) {
        return flightService.updateFlight(flight);
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public @ResponseBody
    List<Flight> patchFlight(@RequestBody Flight flight) {
        return flightService.patchFlight(flight);
    }

}
