package com.mongo.MongoTemplate.service;

import com.mongo.MongoTemplate.model.Employee;
import com.mongo.MongoTemplate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;

  public Employee save(Employee emp) {
    emp.setJoingDate(new Date());
    return employeeRepository.save(emp);
  }

  public List<Employee> getAll() {
    return employeeRepository.getAll();
  }

  public Employee update(Employee emp) {
    return employeeRepository.update(emp);
  }

  public Long delete(Employee emp) {
    return employeeRepository.delete(emp);
  }

  public List<Employee> getBySalary(int salary) {
    return employeeRepository.getBySalary(salary);
  }

  public List<Employee> getByFirstname(String firstname) {
    return employeeRepository.getByFirstname(firstname);
  }
}
