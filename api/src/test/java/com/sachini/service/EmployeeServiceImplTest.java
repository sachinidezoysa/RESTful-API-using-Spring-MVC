package com.sachini.service;


import com.sachini.model.Employee;
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

/*    @Test
    public void addEmployee() {
        Employee employee = new Employee();

//        employee.setId(1);
        employee.setAddress("dkjfasskhfiusdyfis");
        employee.setEmail("sdf@.v");
        employee.setName("bawanthi");
        employee.setTelephone("0123547896");

        employeeService.addEmployee(employee);
    }*/

    @Test
    public void getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        for (Employee list:employeeList){
            System.out.println(list.getId());
        }
    }
/*
    @Test
    public void deleteEmployee() {
        employeeService.deleteEmployee(3);
    }

    @Test
    public void getEmployee() {
        Employee employee = new Employee();
        employeeService.getEmployee(11);

        List<Employee> employeeList = employeeService.getAllEmployees();
        for (Employee list:employeeList){
            if ( employee.getId() == 11){
                System.out.println("getEmployee");
            }
        }

    }

    @Test
    public void updateEmployee() {
        Employee employee = new Employee();
        employeeService.getEmployee(11);

        List<Employee> employeeList = employeeService.getAllEmployees();
        for (Employee list:employeeList){
            if ( employee.getId() == 11){
                System.out.println("getEmployee");
            }
        }
    }*/
}