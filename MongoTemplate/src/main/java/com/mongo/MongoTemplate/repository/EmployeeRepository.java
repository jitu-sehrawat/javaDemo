package com.mongo.MongoTemplate.repository;

import com.mongo.MongoTemplate.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {
  @Autowired
  MongoTemplate mongoTemplate;

  public Employee save(Employee emp) {
    return mongoTemplate.save(emp);
  }

  public List<Employee> getAll() {
    return mongoTemplate.findAll(Employee.class);
  }

  public Employee update(Employee emp) {
    return mongoTemplate.save(emp);
  }

  public Long delete(Employee emp) {
    return mongoTemplate.remove(emp).getDeletedCount();
  }

  public List<Employee> getBySalary(int salary) {
    Query query= new Query(Criteria.where("salary").gte(salary));
    return mongoTemplate.find(query, Employee.class);
  }

  public List<Employee> getByFirstname(String firstname) {
    Query query= new Query(Criteria.where("firstName").regex("^"+firstname));
    return mongoTemplate.find(query, Employee.class);
  }
}
