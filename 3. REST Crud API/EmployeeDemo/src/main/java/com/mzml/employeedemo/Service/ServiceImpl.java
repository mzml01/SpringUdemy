package com.mzml.employeedemo.Service;

import com.mzml.employeedemo.DAO.EmployeeDAOImpl;
import com.mzml.employeedemo.Entity.Employee;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceImpl implements ServiceClass {
    private EmployeeDAOImpl employeeDAO;
    public ServiceImpl(EmployeeDAOImpl employeeDAO){
        this.employeeDAO = employeeDAO;
    }
    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) {
        return employeeDAO.findById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }
}
