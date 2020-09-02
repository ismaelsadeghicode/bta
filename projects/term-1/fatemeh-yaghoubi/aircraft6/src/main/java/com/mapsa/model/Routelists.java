package com.mapsa.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;
@Entity
public class Routelists {
    private long id;
    private String origin;
    private String destination;
    private String movingtime;
    private String returningtime;

    @Id
    @Column(name = "ID", table = "ROUTELISTS")
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ORIGIN", table = "ROUTELISTS")
    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    @Basic
    @Column(name = "DESTINATION", table = "ROUTELISTS")
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    @Basic
    @Column(name = "MOVINGTIME", table = "ROUTELISTS")
    public String getMovingtime() {
        return movingtime;
    }

    public void setMovingtime(String movingtime) {
        this.movingtime = movingtime;
    }

    @Basic
    @Column(name = "RETURNINGTIME", table = "ROUTELISTS")
    public String getReturningtime() {
        return returningtime;
    }

    public void setReturningtime(String returningtime) {
        this.returningtime = returningtime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Routelists that = (Routelists) o;
        return id == that.id &&
                Objects.equals(origin, that.origin) &&
                Objects.equals(destination, that.destination) &&
                Objects.equals(movingtime, that.movingtime) &&
                Objects.equals(returningtime, that.returningtime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origin, destination, movingtime, returningtime);
    }
}
