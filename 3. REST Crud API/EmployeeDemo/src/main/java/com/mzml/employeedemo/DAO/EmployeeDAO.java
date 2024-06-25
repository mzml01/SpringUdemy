package com.mzml.employeedemo.DAO;

import com.mzml.employeedemo.Entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findAll();
    public Employee findById(int id);
    public Employee save(Employee employee);
    public void deleteById(int id);
}
