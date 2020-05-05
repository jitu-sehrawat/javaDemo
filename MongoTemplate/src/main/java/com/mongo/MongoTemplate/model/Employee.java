package com.mongo.MongoTemplate.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Employee {

  @Id
  private String id;
  private String firstName;
  private String lastName;
  private Float salary;
  private Address address;
  private Date joingDate;

  public Employee() {
    super();
  }

  public Employee(String id, String firstName, String lastName, Float salary, Address address, Date joingDate) {
    super();
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.salary = salary;
    this.address = address;
    this.joingDate = joingDate;
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

  public Float getSalary() {
    return salary;
  }

  public void setSalary(Float salary) {
    this.salary = salary;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public Date getJoingDate() {
    return joingDate;
  }

  public void setJoingDate(Date joingDate) {
    this.joingDate = joingDate;
  }
}
