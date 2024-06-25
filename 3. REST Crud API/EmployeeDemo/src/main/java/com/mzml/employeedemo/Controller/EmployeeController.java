package com.mzml.employeedemo.Controller;

import com.mzml.employeedemo.DAO.EmployeeDAOImpl;
import com.mzml.employeedemo.Entity.Employee;
import com.mzml.employeedemo.Service.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private ServiceImpl employeeService;
    @Autowired
    public EmployeeController(ServiceImpl employeeService){
        this.employeeService = employeeService;
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return employeeService.findAll();
    }
    @GetMapping("/employee/{id}")
    public Employee getEmployeeId(@PathVariable int id) {

        Employee employee= employeeService.findById(id);
        if(employee==null){
            throw new RuntimeException("Employee not found");
        }
        return employee;
    }
    @PostMapping("/employee")
    public Employee addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        return employeeService.save(employee);
    }
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteById(id);
        return "Employee with id "+id+" deleted";
    }
    @PutMapping("/employee/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        Employee existingEmployee=employeeService.findById(id);
        if(existingEmployee==null){
            throw new RuntimeException("Employee not found with id "+id+" to update");
        }
        employee.setId(id);
        return employeeService.save(employee);
    }
}
