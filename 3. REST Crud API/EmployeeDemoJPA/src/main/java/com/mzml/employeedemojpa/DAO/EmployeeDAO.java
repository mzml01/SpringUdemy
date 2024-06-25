package com.mzml.employeedemojpa.DAO;

import com.mzml.employeedemojpa.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}
