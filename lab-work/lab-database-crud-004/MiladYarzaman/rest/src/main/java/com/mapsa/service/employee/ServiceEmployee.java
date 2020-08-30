package com.mapsa.service.employee;

import com.mapsa.dao.employee.EmployeeDaoImpl;
import com.mapsa.dao.employee.IEmployeeDao;
import com.mapsa.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ServiceEmployee {
    @Autowired
    IEmployeeDao employeeDao;

    public boolean creatEmployee(Employee employee){
        employeeDao.creatEmployee(employee);
        return true;
    }
    public List<Employee> getEmployees(){
      return   employeeDao.getEmployees();

    }
    public boolean deleteEmployById(long id){
        System.out.println("in  service");
        employeeDao.deleteEmployById(id);
        return true;
    }
}
