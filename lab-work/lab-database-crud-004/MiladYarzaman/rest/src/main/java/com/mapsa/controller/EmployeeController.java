package com.mapsa.controller;

import com.mapsa.models.Employee;
import com.mapsa.service.employee.ServiceEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    ServiceEmployee serviceEmployee;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody List<Employee> employeeList(){
        List<Employee> employees=serviceEmployee.getEmployees();
        return employees;
    }
    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody void creatEmployee(@RequestBody Employee employee){

        System.out.println(employee.getFirstName());
        serviceEmployee.creatEmployee(employee);
    }
    @RequestMapping("/{id}")
    public void updateEmployeeById(@RequestBody Employee employee,
                                          @PathVariable("id") long id) {


    }
    @RequestMapping(value = "/{id}",method =RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee employee,
                                   @PathVariable("id") long id) {


    }
    @RequestMapping(value = "/{id}",method =RequestMethod.DELETE)
    public void deleteEmployee( @PathVariable("id") String id) {
            long tempid=new Long(id);
            serviceEmployee.deleteEmployById(tempid);


    }
}
