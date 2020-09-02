package com.mapsa.dao.airplane_seat;

import com.mapsa.models.AirplaneSeat;

import java.util.List;

public interface IAirplaneSeat {
    public long createAirplanSeat(AirplaneSeat airplanSeat);
    public boolean setAirplaneSeatBusy(long seatNumber);
    public boolean setAirplaneSeatFree(long seatNumber);
    public List<AirplaneSeat> getAirplaneSeatListByFlightId(long flightNumber);
    public List<AirplaneSeat> getFreeAirplaneSeatListByFlightId(long flightNumber);
    public AirplaneSeat getAirplaneSeatById(long aireplaneSeatId);
}
