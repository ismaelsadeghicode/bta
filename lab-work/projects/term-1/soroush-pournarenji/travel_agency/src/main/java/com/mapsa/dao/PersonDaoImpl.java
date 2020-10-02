package com.mapsa.dao;

import com.mapsa.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Person> findAllPerson() {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Person");
        List<Person> people=query.list();
        session.flush();
        return people;
    }

    @Override
    public Person getPersonById(long id) {
        Session session=sessionFactory.getCurrentSession();
        Person person=session.get(Person.class,id);
        return person;
    }

    @Override
    public void addPerson(Person person) {
        Session session=sessionFactory.getCurrentSession();
        session.save(person);
        session.flush();
    }

    @Override
    public void editPerson(Person person) {
        Session session=sessionFactory.getCurrentSession();
        session.saveOrUpdate(person);
        session.flush();
    }

    @Override
    public void deletePerson(Person person) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(person);
        session.flush();
    }

    @Override
    public List<Person> findAllPeronByAccountId(long id) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Person where  accountId=:id").setParameter("id",id);
        List<Person> people=query.list();
        session.flush();
        return people;
    }
}
