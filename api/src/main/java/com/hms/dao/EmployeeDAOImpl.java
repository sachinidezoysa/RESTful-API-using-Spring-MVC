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
package com.hms.dao;

import hms.model.Employee;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * EmployeeDAO class will help to access data from database of data storage
 *
 * @author sachini de zoysa
 */
@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    public void setSessionFactory(SessionFactory sessionFactory) {    //because I'm using classic hibernate APIs
        this.sessionFactory = sessionFactory;
    }

    @Autowired
    private SessionFactory sessionFactory;

    /**
     * method addEmployee is to add a new employee to the database
     * @param employee
     */
    public void addEmployee(Employee employee) {
        sessionFactory.getCurrentSession().saveOrUpdate(employee);
    }

    /**
     * method getAllEmployee is to get all the employees from the database
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Employee> getAllEmployees() {
        return sessionFactory.getCurrentSession().createQuery("from Employee").list();
    }

    /**
     * deleteEmployee method is to delete a saved employee from his employee ID
     * @param employeeId
     */
    public void deleteEmployee(Integer employeeId) {
        Employee employee = (Employee) sessionFactory.getCurrentSession().load(
                Employee.class, employeeId);
        if (null != employee) {
            this.sessionFactory.getCurrentSession().delete(employee);
        }
    }

    /**
     * method updateEmployee is to update a saved employee details
     * @param employee
     * @return
     */
    public Employee updateEmployee(Employee employee) {
        sessionFactory.getCurrentSession().update(employee);
        return employee;
    }

    /**
     * getEmployee method is to print a saved employee from employeeID
     * @param employeeid
     * @return
     */
    public Employee getEmployee(int employeeid) {
        return sessionFactory.getCurrentSession().get(
                Employee.class, employeeid);
    }
}