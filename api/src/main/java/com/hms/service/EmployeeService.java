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

import hms.model.Employee;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * EmployeeService interface is implementing from EmployeeServiceImpl.class.
 *
 * @author sachini de zoysa
 */
@Component("EmployeeService")
public interface EmployeeService {

    public Employee addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Integer employeeId);

    public Employee getEmployee(int employeeid);

    public Employee updateEmployee(Employee employee);

}