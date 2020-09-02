package com.mapsa.dao;

import com.mapsa.model.Routelists;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;


@Repository
@Transactional
public class RouteListDaoImpl implements RouteListDao{

    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Routelists> findAllRouteList() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery( "from Routelists" );
        List<Routelists> routeLists=query.list();
        session.flush();
        return routeLists;
    }

    @Override
    public Routelists getRouteListById(long id) {
        Session session=sessionFactory.getCurrentSession();
        Routelists routeList =(Routelists)session.get(Routelists.class,id  );
        session.flush();
        return null;
    }

    @Override
    public void addRouteList(Routelists routeList) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate( routeList );
        session.flush();

    }

    @Override
    public void editeRouteList(Routelists routeList) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate( routeList );
        session.flush();

    }

    @Override
    public void delete(Routelists routeList) {
        Session session=sessionFactory.getCurrentSession();
        session.delete( routeList );
        session.flush();


    }

}