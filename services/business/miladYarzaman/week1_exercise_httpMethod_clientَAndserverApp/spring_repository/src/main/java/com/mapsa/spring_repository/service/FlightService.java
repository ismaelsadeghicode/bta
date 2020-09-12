package com.mapsa.spring_repository.service;

import com.mapsa.spring_repository.data.flight.SearchFlightDto;
import com.mapsa.spring_repository.domain.Flight;
import com.mapsa.spring_repository.repository.flight.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;
    public List<Flight> getFlightsByDesAndSrc(SearchFlightDto searchFlightDto){
        if(searchFlightDto.destinationAndSourceValidation()){
                      return flightRepository.findAllByDestinationAndSource(searchFlightDto.getDestination(), searchFlightDto.getSource());

        }else if(searchFlightDto.destinationValidation()){
                       return flightRepository.findAllByDestination(searchFlightDto.getDestination());

        }else if(searchFlightDto.sourceValidation()){
                       return flightRepository.findAllBySource(searchFlightDto.getSource());

        }else{
                      return null;//////////////or throw exception.

        }

    }
    public Flight putUpdate(Flight flight){

        Optional<Flight> flightTempOptional=flightRepository.findById(flight.getId());

        if(flightTempOptional.isPresent()){
            Flight flightTemp=flightTempOptional.get();

            flightTemp.setSource(flight.getSource());
            flightTemp.setDestination(flight.getDestination());
            flightTemp.setId(flight.getId());

           return flightRepository.save(flightTemp);
        }else {
          return flightRepository.save(flight);
        }


    }
    public Flight patchUpdate(Flight flight) {

        Optional<Flight> flightTempOptional = flightRepository.findById(flight.getId());

        if (flightTempOptional.isPresent()) {
            Flight flightTemp = flightTempOptional.get();
                if(flight.getDestination()!=null)
                    flightTemp.setDestination(flight.getDestination());

            if(flight.getSource()!=null)
                flightTemp.setSource(flight.getSource());


            return flightRepository.save(flightTemp);
        } else {
            return null;
        }
    }
}
