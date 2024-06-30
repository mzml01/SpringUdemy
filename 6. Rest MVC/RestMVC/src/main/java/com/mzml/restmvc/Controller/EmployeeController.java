package com.mzml.restmvc.Controller;

import com.mzml.restmvc.Entity.Employee;
import com.mzml.restmvc.Service.EmployeeServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class EmployeeController {
    private EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String getEmployee(Model theModel) {
        List<Employee> employee = employeeService.findAll();
        theModel.addAttribute("employee", employee);
        return "employee-list";
    }

    @GetMapping("/employees/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        Employee employee = new Employee();
        theModel.addAttribute("employee", employee);
        return "employee-form";
    }

    @PostMapping("/employees/save")
    public String saveEmployee(@ModelAttribute("employee") Employee theEmployee) {
        employeeService.save(theEmployee);
        return "redirect:/employees";
    }

    @PostMapping("/employees/byId")
    public String getEmployeeById(@RequestParam("id") int id, Model theModel) {
        Employee employee = employeeService.findById(id);
        theModel.addAttribute("employee", employee);
        return "employee-details";
    }

    @GetMapping("/employees/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("id") int id, Model theModel) {
        Employee employee = employeeService.findById(id);
        theModel.addAttribute("employee", employee);
        return "employee-form";
    }
    @GetMapping("/employees/delete")
    public String deleteEmployee(@RequestParam("id") int id){
        employeeService.deleteById(id);
        return "redirect:/employees";
    }
}
