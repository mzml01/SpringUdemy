package com.mzml.employeedemorestdependency;

import com.mzml.employeedemorestdependency.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
