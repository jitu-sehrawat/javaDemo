package com.example.demoEmbeddedMongo.controller;

import com.example.demoEmbeddedMongo.Entity.Employee;
import com.example.demoEmbeddedMongo.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/")
  public List<Employee> getAll() {
    return  employeeService.getAll();
  }
  @PostMapping("/")
  public String add(@RequestBody Employee employee) {
    return  employeeService.add(employee);
  }
  @PutMapping("/")
  public String udpate(@RequestBody Employee employee) {
    return  employeeService.udpate(employee);
  }
  @DeleteMapping("/")
  public String delete(@PathParam("id") String id) {
    return  employeeService.delete(id);
  }
}
