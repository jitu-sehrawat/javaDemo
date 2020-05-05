package com.mongo.mongoRepository;

import com.mongo.mongoRepository.model.Address;
import com.mongo.mongoRepository.model.Employee;
import com.mongo.mongoRepository.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MongoRepositoryApplication implements CommandLineRunner {
@Autowired
	EmployeeRepository employeeRepository;
	public static void main(String[] args) {
		SpringApplication.run(MongoRepositoryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Employee> listOfEmployees = new ArrayList<Employee>();

		Employee e1 = new Employee(
				"jitender",
				"sehrawat",
				5000,
				new Address(
						"A-94",
						"Road No.2",
						"Mahipalpur",
						"New Delhi",
						110037
				)
		);
		Employee e2 = new Employee(
				"rahul",
				"sehrawat",
				10000,
				new Address(
						"A-95",
						"Road No.2",
						"Mahipalpur",
						"New Delhi",
						110037
				)
		);
		Employee e3 = new Employee(
				"kartik",
				"sehrawat",
				15000,
				new Address(
						"A-96",
						"Road No.2",
						"Mahipalpur",
						"New Delhi",
						110037
				)
		);
		Employee e4 = new Employee(
				"reetu",
				"sehrawat",
				20000,
				new Address(
						"A-97",
						"Road No.2",
						"Mahipalpur",
						"New Delhi",
						110037
				)
		);
		Employee e5 = new Employee(
				"prachi",
				"sehrawat",
				25000,
				new Address(
						"A-98",
						"Road No.2",
						"Mahipalpur",
						"New Delhi",
						110037
				)
		);

		listOfEmployees.add(e1);
		listOfEmployees.add(e2);
		listOfEmployees.add(e3);
		listOfEmployees.add(e4);
		listOfEmployees.add(e5);

		employeeRepository.insert(listOfEmployees);
	}
}
