package com.example.demoEmbeddedMongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoEmbeddedMongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoEmbeddedMongoApplication.class, args);
	}

	// MongoDB Connection
	public MongoClient getClient(){
		return new MongoClient("localhost", 27027);
	}
	@Override
	public void run(String... args) throws Exception {

		MongoClient mongoClient = getClient();
		MongoDatabase database = mongoClient.getDatabase("test");
		MongoCollection<Document> employeeCollection = database.getCollection("employee");

		Document employee1 = new Document();
		employee1.append("firstName", "Bat");
		employee1.append("lastName", "Man");
		employee1.append("location", "Bat Cave");

		employeeCollection.insertOne(employee1);
	}
}
