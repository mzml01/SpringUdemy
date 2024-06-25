package com.mzml.employeedemojpa.Controller;

import com.mzml.employeedemojpa.DAO.EmployeeDAO;
import com.mzml.employeedemojpa.Entity.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class EmployeeController {
    private EmployeeDAO employeeDAO;
    public EmployeeController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeDAO.findAll();
    }
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeDAO.findById(id).get();
    }
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {
        employee.setId(0);
        return employeeDAO.save(employee);
    }
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeDAO.save(employee);
    }
    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeDAO.deleteById(id);
        return "Employee with id " + id + " deleted";
    }
}
