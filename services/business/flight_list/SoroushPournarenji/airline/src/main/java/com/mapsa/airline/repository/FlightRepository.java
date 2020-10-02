package com.mapsa.airline.repository;

import com.mapsa.airline.domin.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends  JpaRepository<Flight,Long>{

}
