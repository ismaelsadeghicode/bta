package com.mapsa.dao;

import com.mapsa.model.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {


    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> findAllUsers() {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User order by id desc ");
        session.flush();
        List<User> userList = query.list();
        return userList;

    }


    @Override

    public User getUserById(int id) {

        Session session = sessionFactory.getCurrentSession();
        User user = session.get(User.class, id);
        session.flush();
        return user;

    }


    @Override

    public User getUserByUsername(String username) {

        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from User u where u.username = :user").setParameter("user", username);
        User user = (User) query.uniqueResult();
        return user;

    }


    @Override

    public void insertUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.save(user);
        session.flush();

    }


    @Override

    public void updateUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.update(user);
        session.flush();

    }


    @Override

    public void deleteUser(User user) {

        Session session = sessionFactory.getCurrentSession();
        session.delete(user);
        session.flush();

    }

}