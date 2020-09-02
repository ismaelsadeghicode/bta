package com.mapsa.dao.flight;

import com.mapsa.models.Flight;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Repository
@Transactional
public class FlightDaoImpl implements IFlight {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public long createFlight(Flight flight) {
        long id;
        Session session=sessionFactory.getCurrentSession();
        try {
            id= (long) session.save(flight);
        }catch (HibernateException e){
            id=-1;/////////////derty code. here must use  exeption handeling
        }finally {
            session.flush();
        }

        return id;

         }

    @Override
    public List<Flight> getFlightList() {
        List<Flight> flightList;
        Session session=sessionFactory.getCurrentSession();
        try {
            Query query=session.createQuery("from Flight ");
            flightList=new ArrayList<>();
          flightList=query.list();
        }catch (HibernateException e){
            flightList=null;///////////derty code
        }finally {
            session.flush();
        }

        return flightList;
    }

    @Override
    public Flight getFlightById(long flightId) {
        Flight flight;
        Session session=sessionFactory.getCurrentSession();
       /* Query query = session.createQuery("from Flight where id = :flightId ");
        query.setParameter("flightId",flightId);
        List list = query.list();

        session.flush();
        if(list.size()>0){return (Flight) list.get(0);}else{return null;}*/

        ////////////
        try{
            flight=session.get(Flight.class,flightId);
        }catch (HibernateException e){
            flight=null;////////derty code
            e.printStackTrace();
        }finally {
            session.flush();
        }

        return flight;

    }

    @Override
    public boolean deleteFlightById(long id) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("delete from Flight where id=id");
        if (query.executeUpdate()>0)
            return true;
        else
        return false;
    }

    @Override
    public boolean updateFlight(Flight flight) {
        boolean response;
        Session session=sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(flight);
            response=true;
        }catch (HibernateException e){
            response=false;
        }finally {
            session.flush();
        }


        return response;
    }

    @Override
    public List<Flight> getFlightByDestination(String destination) {


        Session session=sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Flight where destination= :dest");

        query.setParameter("dest",destination);

        List list = query.list();

        System.out.println("*******"+list.size()+destination+"**************************");
        session.flush();
        return list;
        /*Query query = session.createQuery("from Flight where destination = :dest ");
        query.setParameter("dest",destination);
        List list = query.list();
        session.get(Flight.class,destination);*/
       /* EntityManager entityManager=session.getEntityManagerFactory().createEntityManager();
        List<Flight> flightList = session.createNativeQuery(
                "SELECT * FROM FLIGHT where DESTINATION=:dest").setParameter("dest",destination)
                .getResultList();*/

    }

    @Override
    public List<Flight> getFlightByDestinationAndDate(String destination, Date date) {
        Session session=sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Flight where destination = :dest AND flightDate=:date");
        query.setParameter("dest",destination);
    //    query.setParameter("date",date);
        List list = query.list();
        session.flush();
        return list;
    }

    @Override
    public List<Flight> getFlightByDestinationAndSource(String destination, String origin) {
        Session session=sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Flight where destination = :dest AND origin=:origin");
        query.setParameter("dest",destination);
        query.setParameter("origin",origin);
        List list = query.list();
        session.flush();
        return list;
    }
}
