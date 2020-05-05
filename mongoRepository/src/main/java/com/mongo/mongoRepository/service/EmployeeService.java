package com.mongo.mongoRepository.service;

import com.mongo.mongoRepository.model.Employee;
import com.mongo.mongoRepository.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {
  @Autowired
  EmployeeRepository employeeRepository;

  public List<Employee> getAll() {
    return employeeRepository.findAll();
  }

  public Employee save(Employee emp) {
    return employeeRepository.insert(emp);
  }
//
//
  public Employee update(Employee emp) {
    return employeeRepository.save(emp);
  }
//
  public void delete(String id) {
    employeeRepository.deleteById(id);
  }

  public Map<String, Object> getAllEmployeeInPage(Integer pageNos, Integer pageSize, String sortBy) {
    Map<String, Object> response = new HashMap<String, Object>();

    Sort sort = Sort.by(sortBy);
    Pageable page = PageRequest.of(pageNos,pageSize,sort);
    Page<Employee> employeePage = employeeRepository.findAll(page);

    response.put("data",employeePage.getContent());
    response.put("Total No Of Pages",employeePage.getTotalPages());
    response.put("Total No Of Elements",employeePage.getTotalElements());
    response.put("Current page No",employeePage.getNumber());

    return  response;
  }

  public List<Employee> getAllByExample(Employee emp) {
    ExampleMatcher matcher = ExampleMatcher.matchingAny().withIgnoreCase();
    Example<Employee> example = Example.of(emp, matcher);

    return employeeRepository.findAll(example);
  }
}
