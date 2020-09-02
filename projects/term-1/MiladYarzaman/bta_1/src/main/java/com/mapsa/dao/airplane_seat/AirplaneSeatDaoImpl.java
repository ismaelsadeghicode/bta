package com.mapsa.dao.airplane_seat;

import com.mapsa.models.AirplaneSeat;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository
@Transactional
public class AirplaneSeatDaoImpl implements IAirplaneSeat {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public long createAirplanSeat(AirplaneSeat airplanSeat) {
        System.out.println("******************************************************************"+
                airplanSeat.getFLIGHT().getId());
        Session session=sessionFactory.getCurrentSession();
       long seatNumber=(long) session.save(airplanSeat);
        session.flush();
        return seatNumber;
    }

    @Override
    public boolean setAirplaneSeatBusy(long seatNumber) {
        return false;
    }

    @Override
    public boolean setAirplaneSeatFree(long seatNumber) {
        return false;
    }

    @Override
    public List<AirplaneSeat> getAirplaneSeatListByFlightId(long flightNumber) {
        return null;
    }

    @Override
    public List<AirplaneSeat> getFreeAirplaneSeatListByFlightId(long flightNumber) {
        return null;
    }

    @Override
    public AirplaneSeat getAirplaneSeatById(long aireplaneSeatId) {
        return null;
    }
}
