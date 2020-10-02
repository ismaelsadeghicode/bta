package com.mapsa.dao;

import com.mapsa.model.Flight;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class FlightDaoImpl implements FlightDao {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Flight> findAllFlight() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Flight ");
        List<Flight> flights=query.list();
        session.flush();
        return flights;
    }

    @Override
    public Flight getFlightById(long id) {
        Session session=sessionFactory.getCurrentSession();
        Flight flight=session.get(Flight.class,id);
        session.flush();
        return flight;
    }

    @Override
    public void addFlight(Flight flight) {
        Session session=sessionFactory.getCurrentSession();
        session.save(flight);
        session.flush();
    }

    @Override
    public void editFlight(Flight flight) {
        Session session=sessionFactory.getCurrentSession();
        session.update(flight);
        session.flush();
    }

    @Override
    public void deleteFlight(Flight flight) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(flight);
        session.flush();
    }
}
