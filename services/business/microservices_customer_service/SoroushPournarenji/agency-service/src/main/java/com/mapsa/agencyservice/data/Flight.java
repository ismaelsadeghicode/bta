package com.mapsa.agencyservice.data;

import lombok.Data;

@Data
public class Flight {
    private Long id;
    private String company;
    private String origin;
    private String destination;
    private int quantity;
    private Long fee;
    private String description;

}
