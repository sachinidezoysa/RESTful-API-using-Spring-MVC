package com.sachini.service;


import com.sachini.model.Employee;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class EmployeeServiceImplTest {

    @Autowired
    private EmployeeService employeeService;

    @Before
    public void addEmployee() {
        Employee employee = new Employee();

        employee.setId(9);
        employee.setAddress("hedffgy");
        employee.setEmail("sdsdss@.v");
        employee.setName("dfdfgfdgf");
        employee.setTelephone("01235sadas47896");

        employeeService.addEmployee(employee);
    }

    @Test
    public void getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        for (Employee list:employeeList){
            System.out.println(list.getId());
        }
    }

    @Test
    public void getEmployee() {
        Employee employee = new Employee();
        employeeService.getEmployee(2);

        List<Employee> employeeList = employeeService.getAllEmployees();
        for (Employee list:employeeList){
            if ( employee.getId() == 1){
                System.out.println("getEmployee");
            }
        }

    }

    @Test
    public void updateEmployee() {
        Employee employee = new Employee();
        employeeService.getEmployee(1);

        List<Employee> employeeList = employeeService.getAllEmployees();
        for (Employee list:employeeList){
            if ( employee.getId() == 1){
                System.out.println("getEmployee");
            }
        }
    }

    @After
    public void deleteEmployee() {
        employeeService.deleteEmployee(9);
    }
}