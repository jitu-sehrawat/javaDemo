package com.mongo.MongoTemplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class MongoTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(MongoTemplateApplication.class, args);
	}

}
