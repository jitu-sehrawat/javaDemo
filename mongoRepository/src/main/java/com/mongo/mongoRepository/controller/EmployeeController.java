package com.mongo.mongoRepository.controller;

import com.mongo.mongoRepository.model.Employee;
import com.mongo.mongoRepository.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;


  @GetMapping("/")
  public List<Employee> getAll() {
    return employeeService.getAll();
  }

  @PostMapping("/")
  public Employee save(@RequestBody Employee emp) {
    return employeeService.save(emp);
  }
  @PutMapping("/")
  public Employee update(@RequestBody Employee emp) {
    return employeeService.update(emp);
  }
  @DeleteMapping("/{id}")
  public void delete(@PathVariable("id") String id) {
    employeeService.delete(id);
  }

  // pagination and Sorting
  @GetMapping("/page")
  public Map<String, Object> getAllEmployeeInPage(
      @RequestParam(name = "pageno", defaultValue = "0") Integer pageNos,
      @RequestParam(name = "pagesize", defaultValue = "2") Integer pageSize,
      @RequestParam(name = "sortby", defaultValue = "id") String sortBy
  ) {
    return employeeService.getAllEmployeeInPage(pageNos,pageSize,sortBy);
  }

  // 1. Example Executor (Searching)
  @GetMapping("/example")
  public List<Employee> getAllByExample(@RequestBody Employee emp) {
    return employeeService.getAllByExample(emp);
  }


  // 2.1 QueryByMethodNames
  @GetMapping("/firstName")
  public List<Employee> getAllByFirstName(@RequestParam(name = "firstName") String firstName) {
    return employeeService.getAllByFirstName(firstName);
  }

  // 2.2 QueryByMethodNames Nested Object
  @GetMapping("/zipCode")
  public List<Employee> getAllByZipCode(@RequestParam(name = "zipCode") Integer zipCode) {
    return employeeService.getAllByZipCode(zipCode);
  }


  // 3 Query Baed on JSON
  @GetMapping("/salary")
  public List<Employee> getAllBySalaryGreaterThan(@RequestParam(name = "salary") Integer salary) {
    return employeeService.getAllBySalaryGreaterThan(salary);
  }
}
