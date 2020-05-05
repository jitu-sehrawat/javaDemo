package com.example.demoEmbeddedMongo.Service;

import com.example.demoEmbeddedMongo.Entity.Employee;
import com.example.demoEmbeddedMongo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;


  public List<Employee> getAll() {
    return employeeRepository.getAll();
  }

  public String add(Employee employee) {
    return employeeRepository.save(employee);
  }

  public String udpate(Employee employee) {
    return employeeRepository.update(employee);
  }

  public String delete(String id) {
    return employeeRepository.delete(id);
  }
}
