package com.luv2code.cruddemo.rest;

import com.luv2code.cruddemo.dao.EmployeeDAO;
import com.luv2code.cruddemo.entity.Employee;
import com.luv2code.cruddemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    //get employee service
    private EmployeeService employeeService;
    //Constructor injection
    @Autowired
    public EmployeeRestController(EmployeeService employeeService1){
        employeeService = employeeService1;
    }

    //get list of data
    @GetMapping("/employees")
    public List<Employee> getEmployeeList(){
        return employeeService.findAll();
    }

    //get employee by id GET employees/{employeeId}
    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeById(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("Employee not found with id "+ employeeId);
        }
        return employee ;
    }

    //Save employee
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
       employee.setId(0);
        employeeService.save(employee);
        return employee;
    }

    //update existing employee
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return employee;
    }

    //Delete employee using employeeId
    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee employee = employeeService.findById(employeeId);
        if(employee==null){
            throw new RuntimeException("Employee not found with id "+ employeeId);
        }

        employeeService.deleteById(employeeId);
        return "Deleted employee details with id "+employeeId;
    }
}
