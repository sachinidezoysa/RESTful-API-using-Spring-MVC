package com.sachini.dao;

import com.sachini.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Integer employeeId);

    public Employee updateEmployee(Employee employee);

    public Employee getEmployee(int employeeid);
}
