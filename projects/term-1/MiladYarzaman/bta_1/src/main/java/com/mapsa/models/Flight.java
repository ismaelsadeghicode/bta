package com.mapsa.models;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

@Entity
public class Flight {
    private long id;
    private String name;
    private String company;
    private String origin;
    private String destination;
    private Timestamp flightDate;
    private Timestamp arivalDate;
    private int airplaneSeatNumber;
    private long fee;
    private String description;
    private List<AirplaneSeat> airplaneSeatList;

    @Id
    @Column(name = "ID", nullable = false, precision = 0)
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "NAME", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "COMPANY", nullable = false, length = 100)
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Basic
    @Column(name = "ORIGIN", nullable = false, length = 100)
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Basic
    @Column(name = "DESTINATION", nullable = false, length = 100)
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "FLIGHT_DATE", nullable = false)
    public Timestamp getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Timestamp flightDate) {
        this.flightDate = flightDate;
    }

    @Basic
    @Column(name = "ARIVAL_DATE", nullable = false)
    public Timestamp getArivalDate() {
        return arivalDate;
    }

    public void setArivalDate(Timestamp arivalDate) {
        this.arivalDate = arivalDate;
    }

    @Basic
    @Column(name = "AIRPLANE_SEAT_NUMBER", nullable = false, precision = 0)
    public int getAirplaneSeatNumber() {
        return airplaneSeatNumber;
    }

    public void setAirplaneSeatNumber(int airplaneSeatNumber) {
        this.airplaneSeatNumber = airplaneSeatNumber;
    }

    @Basic
    @Column(name = "FEE", nullable = false, precision = 4)
    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return id == flight.id &&
                airplaneSeatNumber == flight.airplaneSeatNumber &&
                fee == flight.fee &&
                Objects.equals(name, flight.name) &&
                Objects.equals(company, flight.company) &&
                Objects.equals(origin, flight.origin) &&
                Objects.equals(destination, flight.destination) &&
                Objects.equals(flightDate, flight.flightDate) &&
                Objects.equals(arivalDate, flight.arivalDate) &&
                Objects.equals(description, flight.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, company, origin, destination, flightDate, arivalDate, airplaneSeatNumber, fee, description);
    }

    @OneToMany(mappedBy = "FLIGHT",fetch = FetchType.EAGER)
    public List<AirplaneSeat> getAirplaneSeats() {
        return airplaneSeatList;
    }

    public void setAirplaneSeats(List<AirplaneSeat> ID) {
        this.airplaneSeatList = ID;
    }
}
