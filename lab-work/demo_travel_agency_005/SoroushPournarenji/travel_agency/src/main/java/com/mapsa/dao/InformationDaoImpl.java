package com.mapsa.dao;

import com.mapsa.model.Account;
import com.mapsa.model.Information;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class InformationDaoImpl implements InformationDao {
    @Autowired
    SessionFactory sessionFactory;


    @Override
    public Information getInformationById(long id) {
        Session session=sessionFactory.getCurrentSession();
        Information information=session.get(Information.class,id);
        session.flush();
        return information;
    }

    @Override
    public Information getInformationByAccountId(long id) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Information where accountId=:id")
                .setParameter("id",id);
        Information information=null;
        if (!query.list().isEmpty()) {
            information = (Information) query.getSingleResult();
        }
        session.flush();
        return information;
    }

    @Override
    public void addInformation(Information information) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(information);
        session.flush();
    }

}
