package com.test.controller;

import com.test.model.Flight;
import com.test.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.jws.WebService;
import java.io.IOException;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    private FlightService flightsService;


    @RequestMapping("/flight")
    public String flights(@ModelAttribute("username") String username, Model model) {
        System.out.println(">>>>>>>>>"+username);
        List<Flight> flights = flightsService.flights();
        model.addAttribute("flights",flights);
        model.addAttribute("username",username);
        return "flight";
    }

    @RequestMapping("/")
    public String flights(Model model) {
        List<Flight> flights = flightsService.flights();
        model.addAttribute("flights",flights);
        return "Home";
    }
    @RequestMapping("/flight/{id}")
    public String product(@PathVariable Long id, Model model) throws IOException {
        Flight flight = flightsService.getFlightById(id);
        model.addAttribute(flight);
        return "viewFlight";
    }
}
