package com.mapsa.demo.client.controller.flight;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.mapsa.demo.client.domain.FlightClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("flightclient")
public class FlightClientController {
   @Value("${clientBta.address}")
    String url;
    @GetMapping
    public List<FlightClient> flightsClient(){
       // String url="http://localhost:8080/";

        RestTemplate restTemplate=new RestTemplate();

        List<FlightClient> ress=restTemplate.getForObject(url,List.class);

        return ress;
    }
}
