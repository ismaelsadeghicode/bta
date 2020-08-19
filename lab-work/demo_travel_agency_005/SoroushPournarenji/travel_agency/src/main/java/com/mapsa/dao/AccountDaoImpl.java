package com.mapsa.dao;

import com.mapsa.model.Account;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class AccountDaoImpl implements AccountDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<Account> findAllAccount() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Account ");
        List<Account> accountList = query.list();
        session.flush();
        return accountList;
    }

    @Override
    public Account checkLoginAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        Query query=session.createQuery("from Account where email= : email and password= : password").
                setParameter("email",account.getEmail()).setParameter("password",account.getPassword());
        Account account1=null;
        if (!query.list().isEmpty()) {
            account1 = (Account) query.getSingleResult();
        }
        session.flush();
        return account1;
    }

    @Override
    public Account getAccountById(long id) {
        Session session = sessionFactory.getCurrentSession();
        Account account = session.get(Account.class, id);
        session.flush();
        return account;
    }

    @Override
    public boolean isFindAccountById(long id) {
            if(!getAccountById(id).getEmail().isEmpty()){
                return true;
            }
            return false;
        }

    @Override
    public void addAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.save(account);
        session.flush();
    }

    @Override
    public void editAccount(Account account) {
        Session session = sessionFactory.getCurrentSession();
        session.update(account);
        session.flush();
    }
}
