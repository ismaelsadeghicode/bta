package com.mapsa.demo.client.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class FlightClient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String destination,source;


}
