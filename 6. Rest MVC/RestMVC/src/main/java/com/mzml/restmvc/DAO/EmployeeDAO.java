package com.mzml.restmvc.DAO;

import com.mzml.restmvc.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {
}
