package com.sachini.service;

import com.sachini.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("EmployeeServuce")
public interface EmployeeService {

    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Integer employeeId);

    public Employee getEmployee(int employeeid);

    public Employee updateEmployee(Employee employee);
}