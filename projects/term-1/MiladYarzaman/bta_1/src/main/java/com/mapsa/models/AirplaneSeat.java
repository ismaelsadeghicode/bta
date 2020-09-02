package com.mapsa.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "AIRPLANE_SEAT", schema = "MILAD1370", catalog = "")
public class AirplaneSeat {
    private long id;
    private long seatNumber;
    private String status;

    private Flight FLIGHT;

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
    @Column(name = "SEAT_NUMBER", nullable = false, precision = 0)
    public long getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(long seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Basic
    @Column(name = "STATUS", nullable = false, length = 1)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirplaneSeat that = (AirplaneSeat) o;
        return id == that.id &&
                seatNumber == that.seatNumber &&
                Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, seatNumber, status);
    }

    @ManyToOne(fetch = FetchType.LAZY)

    public Flight getFLIGHT() {
        return FLIGHT;
    }

    public void setFLIGHT(Flight FLIGHT) {
        this.FLIGHT = FLIGHT;
    }
}
