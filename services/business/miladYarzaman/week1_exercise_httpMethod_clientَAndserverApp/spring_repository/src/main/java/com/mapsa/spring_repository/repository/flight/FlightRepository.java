package com.mapsa.spring_repository.repository.flight;

import com.mapsa.spring_repository.domain.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight,Long> {
    List<Flight> findAllByDestinationAndSource(String des,String src);
    List<Flight> findAllByDestination(String des);
    List<Flight> findAllBySource(String src);

}
