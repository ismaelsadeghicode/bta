package com.mapsa.spring_repository.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String destination;
    private String source;
}
