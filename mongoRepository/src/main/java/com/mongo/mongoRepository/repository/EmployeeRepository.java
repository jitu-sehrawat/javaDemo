package com.mongo.mongoRepository.repository;

import com.mongo.mongoRepository.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {

  // QueryByMethodNames
  List<Employee> findByFirstName(String firstName);

  List<Employee> findByAddressZipCode(Integer zipCode);

  // Name Of function doesnot mater
  @Query(value = "{'salary': { $gte: ?0 } }")
  List<Employee> abc(Integer salary);
}
