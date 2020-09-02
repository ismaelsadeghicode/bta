package com.mapsa.dao.account;

import com.mapsa.models.Account;
import com.mapsa.services.account.ConstVariable;
import com.mapsa.services.account.CustomExeption;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class AccountDaoImpl implements IAccount {
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public long createAccount(Account account) throws CustomExeption {
        Session session=sessionFactory.getCurrentSession();
        System.out.println(account.getAddress()+account.getEmail()+account.getNationalCode()+account.getPassword()
        +"/////////////////////////////////////////////////////////////////");
        long id=0;
        try {
          session.save(account);
            System.out.println("???????????????????????????????????????????????????/////");
        }catch (HibernateException e){
           // id=-1;/////////////derty code. here must use  exeption handeling
            throw new CustomExeption(ConstVariable.CAN_NOT_CREATE);
        }finally {
            session.flush();
        }


        return id;
    }

    @Override
    public List<Account> getAccountList() {
        List<Account> accountList;
        Session session=sessionFactory.getCurrentSession();
        try {
            Query query=session.createQuery("from Account ");
            accountList=new ArrayList<>();
            accountList=query.list();
        }catch (HibernateException e){
            accountList=null;///////derty code
        }finally {
            session.flush();
        }
        return accountList;
    }

    @Override
    public Account getAccountById(long accountId) {
        Account account;
        Session session=sessionFactory.getCurrentSession();
             try{
            account=session.get(Account.class,accountId);
        }catch (HibernateException e){
            account=null;////////derty code
            e.printStackTrace();
        }finally {
            session.flush();
        }

        return account;
    }

    @Override
    public boolean deleteAccountById(long id) {
        boolean response;
        Session session=sessionFactory.getCurrentSession();
        try{
            Query query=session.createQuery("delete from Flight where id=id");
            if (query.executeUpdate()>0)
                response= true;
            else
                response= false;
        }catch (HibernateException e){
            response= false;
            e.printStackTrace();
        }finally {
            session.flush();
        }

       return response;
    }

    @Override
    public boolean updateAccount(Account account) {
        boolean response;
        Session session=sessionFactory.getCurrentSession();
        try {
            session.saveOrUpdate(account);
            response=true;
        }catch (HibernateException e){
            response=false;
        }finally {
            session.flush();
        }


        return response;
    }

    @Override
    public Account cheackLoginData(String userName, String password) {
        Account account;
        Session session=sessionFactory.getCurrentSession();
        try {
            Query query = session.createQuery("from Account where (nationalCode = :userName or email=:email)and password=:pass");
            query.setParameter("userName", userName);
            query.setParameter("email", userName);
            query.setParameter("pass", password);
            account=new Account();
            account=(Account) query.list().listIterator();
        }catch (HibernateException e){
            e.printStackTrace();
            account=null;///////derty code
        }
        finally {
            session.flush();
        }

        return account;
    }

    @Override
    public Account findAccountByUserName(String userName) {
        List<Account> account;
        Session session=sessionFactory.getCurrentSession();
        try {
            Query query = session.createQuery("from Account where nationalCode = :userName or email=:email");
            query.setParameter("userName", userName);
            query.setParameter("email", userName);
            account=new ArrayList<>();
            account=query.list();


        }catch (HibernateException e){
            e.printStackTrace();
            account=null;///////derty code
        }
        finally {
            session.flush();
        }
        if(account.size()>0)
            return account.get(0);
        else
            return null;

    }
}
