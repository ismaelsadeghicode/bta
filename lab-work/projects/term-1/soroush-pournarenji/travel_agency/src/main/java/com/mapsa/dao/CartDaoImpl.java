package com.mapsa.dao;

import com.mapsa.model.Cart;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CartDaoImpl implements CartDao{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public Cart getCartById(long id) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Cart where id=:id").setParameter("id",id);
        Cart cart = (Cart) query.getSingleResult();
        session.flush();
        return null;
    }

    @Override
    public void addCart(Cart cart) {
        Session session =sessionFactory.getCurrentSession();
        session.saveOrUpdate(cart);
        session.flush();
    }

    @Override
    public void editCart(Cart cart) {
        Session session=sessionFactory.getCurrentSession();
        session.update(cart);
        session.flush();
    }

    @Override
    public void deleteCart(Cart cart) {
        Session session=sessionFactory.getCurrentSession();
        session.delete(cart);
        session.flush();
    }

    @Override
    public List<Cart> FindListCartByAccountId(long id) {
        Session session=sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Cart where accountId=:id").setParameter("id",id);
        List<Cart> carts=query.list();
        session.flush();
        return carts;
    }
}
