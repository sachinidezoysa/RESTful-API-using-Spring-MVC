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
package com.hms.controller;

import hms.model.Employee;
import com.hms.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * this is my controller class
 * @author sachini de zoysa
 */

@Controller
@Path("/")
@Component
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * In method listEmployee I'm taking a saved employee from his employeeID
     * (here employeeID is hard-codede)
     * @return
     * @throws IOException
     */
    @GET
    @Path("employee")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee listEmployee() throws IOException {
        return employeeService.getEmployee(2);
    }

    /**
     * in method listEmployee I'm taking all the saved employees from the database
     * @return array
     */
    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> listEmployees(){
        return employeeService.getAllEmployees();
    }

    /**
     * here i'm takein a saved em[ployee from his employeeID
     * @param id
     * @return
     */
    @GET
    @Path("employee/{Id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee(@PathParam("Id") int id){
        return employeeService.getEmployee(id);
    }

    /**
     * in method create I'm createing a new employee
     * @param employee
     * @return
     */
    @POST
    @Path("create")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces(MediaType.APPLICATION_JSON)
    public Employee create(@RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }


    /**
     * In method deleteEmployee I'm deleting a saved Employee from
     * his employee ID.
     * @param id
     * @return
     */
    @DELETE
    @Path("delete/{Id}")
    @Produces(MediaType.TEXT_HTML)
    public String deleteEmployee(@PathParam("Id") int id){
        if(employeeService.getEmployee(id)==null){
            return "No user with "+id;
        }else{
            Employee employee = employeeService.getEmployee(id);
            employeeService.deleteEmployee(id);
            return "Employee with ID "+employee.getId()+" deleted Successfully";
        }
    }

    /*private EmployeeService employeeService;

    @GET
    @Path("test")
    @Produces(MediaType.APPLICATION_JSON)
    public String test() {
        System.out.println("-----------test------------");
        return "Test";
    }

    @GET
    @Path("testEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee testEmployee() {
        System.out.println("-----------testEmployee------------");

        Employee employee = new Employee();

        employee.setId(52);
        employee.setEmail("aaaa");
        employee.setAddress("aaaaaaa");
        employee.setName("aa");
        employee.setTelephone("aa");

        return employee;
    }

    @POST
    @Path("addEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee addEmployee(){
        System.out.println("-----------add------------");
        Employee employee = new Employee();

        employee.setAddress("jygk,");
        employee.setName("ssssss");
        employee.setEmail("dfsg@");
        employee.setTelephone("42452");
        employee.setId(22);

        return employee;
    }

    @GET
    @Path("viewEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Employee> viewEmployees(){
        List<Employee> employeeList;
        System.out.println("-----------view------------");
        if (employeeService != null) {
            employeeList = employeeService.getAllEmployees();
            return employeeList;
        }else {
            System.out.println("null");
        }
        return null;
    }

    @GET
    @Path("getEmployee")
    @Produces(MediaType.APPLICATION_JSON)
    public Employee getEmployee() {
        System.out.println("-----------get------------");
        Employee employee = employeeService.getEmployee(38);

        return employee;
    }

    //created a setter method to give access from application context.xml
    @Autowired
    public void setEmployeeService(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }*/

    /*private static final Logger logger = Logger
            .getLogger(EmployeeController.class);

    public EmployeeController() {
        System.out.println("EmployeeController()");
    }

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/")
    public ModelAndView listEmployee(ModelAndView model) throws IOException {
        List<Employee> listEmployee = employeeService.getAllEmployees();
        model.addObject("listEmployee", listEmployee);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        Employee employee = new Employee();
        model.addObject("employee", employee);
        model.setViewName("EmployeeForm");
        return model;
    }

    @RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        if (employee.getId() == 0) { // if employee id is 0 then creating the
            // employee other updating the employee
            employeeService.addEmployee(employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.GET)
    public ModelAndView deleteEmployee(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(employeeId);
        return new ModelAndView("redirect:/");
    }

    @RequestMapping(value = "/editEmployee", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int employeeId = Integer.parseInt(request.getParameter("id"));
        Employee employee = employeeService.getEmployee(employeeId);
        ModelAndView model = new ModelAndView("EmployeeForm");
        model.addObject("employee", employee);

        return model;
    }*/

}