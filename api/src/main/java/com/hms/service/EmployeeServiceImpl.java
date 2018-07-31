/*
 *   (C) Copyright 2017-2018 hSenid Software International (Pvt) Limited.
 *   All Rights Reserved.
 *
 *   These materials are unpublished, proprietary, confidential source code of
 *   hSenid Software International (Pvt) Limited and constitute a TRADE SECRET
 *   of hSenid Software International (Pvt) Limited.
 *
 *   hSenid Software International (Pvt) Limited retains all title to and intellectual
 *   property rights in these materials.
 *
 */
package com.hms.service;

import com.hms.dao.EmployeeDAO;
import hms.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * this is my service class will use EmployeeDAO interface
 * @author sachini de zoysa
 */
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeDAO employeeDAO;

    public Employee addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
        return employee;
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeDAO.getAllEmployees();
    }

    @Transactional
    public void deleteEmployee(Integer employeeId) {
        employeeDAO.deleteEmployee(employeeId);
    }

    @Transactional
    public Employee getEmployee(int employeeid) {
        return employeeDAO.getEmployee(employeeid);
    }

    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }
}