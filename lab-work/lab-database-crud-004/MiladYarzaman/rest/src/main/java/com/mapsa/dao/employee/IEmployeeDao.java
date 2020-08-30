package com.mapsa.dao.employee;

import com.mapsa.models.Employee;

import java.util.List;

public interface IEmployeeDao {
       boolean creatEmployee(Employee employee);
       List<Employee> getEmployees();
       boolean deleteEmployById(long id);
       boolean putEmployee(Employee employee);
       boolean patchEmployee(Employee employee);
}
