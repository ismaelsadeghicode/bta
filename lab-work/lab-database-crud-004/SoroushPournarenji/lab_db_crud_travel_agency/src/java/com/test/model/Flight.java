package com.test.model;

import com.test.persistence.Column;
import com.test.persistence.Entity;
import com.test.persistence.Id;
import com.test.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "FLIGHT")
public class Flight {
    @Id
    @Column(name = "ID", dataType = "NUMBER", length = 5)
    private Long flightId;
    @Column(name = "FLIGHT_NAME", dataType = "VARCHAR", length = 50)
    private String flightName;
    @Column(name = "UNIT_PRICE", dataType = "NUMBER", length = 10)
    private int unitPrice;
    @Column(name = "DESCRIPTION", dataType = "VARCHAR")
    private String description;
    @Column(name = "STATUS_F", dataType = "NUMBER", length = 3)
    private int status;
    @Column(name = "FROM_F", dataType = "VARCHAR", length = 100)
    private String from;
    @Column(name = "TO_F", dataType = "VARCHAR", length = 100)
    private String to;
    @Column(name = "UNIT_IN_STICK", dataType = "NUMBER", length = 3)
    private int unitInStock;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightId, flight.flightId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flightId);
    }

    public Flight() {
    }

    public Flight(Long flightId, String flightName, int unitPrice, String description, int status, String from, String to, int unitInStock) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.unitPrice = unitPrice;
        this.description = description;
        this.status = status;
        this.from = from;
        this.to = to;
        this.unitInStock = unitInStock;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }


    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getUnitInStock() {
        return unitInStock;
    }

    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }
}
