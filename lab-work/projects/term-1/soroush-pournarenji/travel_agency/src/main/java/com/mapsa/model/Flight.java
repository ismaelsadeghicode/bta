package com.mapsa.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;
@Entity
@Table(name ="FLIGHT" )
@SequenceGenerator(
        name="flight_seq",
        sequenceName = "FLIGHT_SEQ",
        allocationSize = 1000,initialValue = 10000
)
@Data
public class Flight {
    @Id
    @Column(name = "ID", table = "FLIGHT",nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "flight_seq")
    private long id;
    @Basic
    @Column(name = "NAME", table = "FLIGHT")
    private String name;
    @Basic
    @Column(name = "COMPANY", table = "FLIGHT")
    private String company;
    @Basic
    @Column(name = "ORIGIN", table = "FLIGHT")
    private String origin;
    @Basic
    @Column(name = "DESTINATION", table = "FLIGHT")
    private String destination;
    @Basic
    @Column(name = "FLIGHT_DATE", table = "FLIGHT")
    private Timestamp flightDate;
    @Basic
    @Column(name = "ARRIVAL_DATE", table = "FLIGHT")
    private Timestamp arrivalDate;
    @Basic
    @Column(name = "QUANTITY", table = "FLIGHT")
    private Byte quantity;
    @Basic
    @Column(name = "FEE", table = "FLIGHT")
    private Long fee;
    @Basic
    @Column(name = "DESCRIPTION", table = "FLIGHT")
    private String description;

}
