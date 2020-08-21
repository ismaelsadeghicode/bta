package com.mapsa.dao.employee;

import com.mapsa.models.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public boolean creatEmployee(Employee employee) throws HibernateException {
        Session session=sessionFactory.getCurrentSession();
        try {
            session.save(employee);
            session.flush();
            return true;
        }catch (HibernateException e) {
            throw new HibernateException(e);
        }
    }

    @Override
    public List<Employee> getEmployees() throws HibernateException {
        Session session=sessionFactory.getCurrentSession();
        try {
            Query query=session.createQuery("from Employee ");
            List<Employee> employees=query.list();
            session.flush();
            return employees;
        }catch (HibernateException e) {
            throw e;
        }

    }

    @Override
    public boolean deleteEmployById(long id) {
                Session session=sessionFactory.getCurrentSession();
        System.out.println("del call"+id);
            try{
         //   String hql = "delete from Vote where uid= :uid AND pid= :pid";
            Query query = session.createQuery("delete Employee where id=:id ");

            query.setParameter("id",id);

            System.out.println(query.executeUpdate());
               session.flush();
            }catch (HibernateException e){
                e.printStackTrace();
            }

        return false;
    }

    @Override
    public boolean putEmployee(Employee employee) {
        return false;
    }

    @Override
    public boolean patchEmployee(Employee employee) {
        return false;
    }
}
