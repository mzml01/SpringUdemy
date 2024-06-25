package com.mzml.employeedemo.DAO;

import com.mzml.employeedemo.Entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
  private EntityManager entityManager;
  public EmployeeDAOImpl(EntityManager entityManager){
    this.entityManager = entityManager;
  }
    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee").getResultList();
    }

  @Override
  public Employee findById(int id) {
    return entityManager.find(Employee.class, id);
  }

  @Override
  public Employee save(Employee employee) {
    Employee dbEmployee = entityManager.merge(employee);
    return employee;
  }

  @Override
  public void deleteById(int id) {
    Employee employee = entityManager.find(Employee.class, id);
    entityManager.remove(employee);
  }
}
