package com.mongo.mongoRepository.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document()
public class Employee {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  private Integer salary;
  private Address address;

  public Employee() {
    super();
  }

  public Employee(String firstName, String lastName, Integer salary, Address address) {
    super();
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
    this.address = address;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

}
