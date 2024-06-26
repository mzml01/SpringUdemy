package com.mzml.restmvc.Controller;

import com.mzml.restmvc.Entity.Employee;
import com.mzml.restmvc.Service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeServiceImpl employeeService;
    public EmployeeController(EmployeeServiceImpl employeeService){
        this.employeeService=employeeService;
    }
    @GetMapping("/employee" )
    public String getEmployee(Model theModel){
        List<Employee> employee=employeeService.findAll();
        theModel.addAttribute("employee",employee);
        return "employee-list";
    }
}
