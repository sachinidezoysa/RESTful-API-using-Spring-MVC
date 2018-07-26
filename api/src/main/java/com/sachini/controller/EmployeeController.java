package com.sachini.controller;

import com.sachini.model.Employee;
import com.sachini.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Controller
@Path("/")
@Component
public class EmployeeController {

    private EmployeeService employeeService;

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
    }

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