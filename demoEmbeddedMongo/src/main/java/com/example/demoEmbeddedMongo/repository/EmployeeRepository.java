package com.example.demoEmbeddedMongo.repository;

import com.example.demoEmbeddedMongo.Entity.Employee;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeRepository {

  private MongoClient client;

  MongoClient getClient() {
    if (client == null) {
      client = new MongoClient("localhost", 27027);
    }

    return client;
  }

  public List<Employee> getAll() {
    MongoClient mongoClient = getClient();
    MongoDatabase database = mongoClient.getDatabase("test");
    MongoCollection<Document> collection = database.getCollection("employee");

    List<Employee> response = new ArrayList<Employee>();

    for (Document e:collection.find()) {
      Employee emp = new Employee(e.get("_id").toString(), e.getString("firstName"), e.getString("lastName"), e.getString("location"));
      response.add(emp);
    }

    return response;
  };

  public String save(Employee employee) {

    MongoClient mongoClient = getClient();
    MongoDatabase database = mongoClient.getDatabase("test");
    MongoCollection<Document> collection = database.getCollection("employee");

    Document emp1 = new Document();
    emp1.append("firstName", employee.getFirstName());
    emp1.append("lastName", employee.getLastName());
    emp1.append("location", employee.getLocation());

    String response = null;
    try {
      collection.insertOne(emp1);
      response = "successfully Added";
    } catch (Exception e) {
      response = "Something wnet wrong";
    }

    return response;
  };

  public String update(Employee employee) {

    MongoClient mongoClient = getClient();
    MongoDatabase database = mongoClient.getDatabase("test");
    MongoCollection<Document> collection = database.getCollection("employee");

    Document emp1 = new Document();
    emp1.append("firstName", employee.getFirstName());
    emp1.append("lastName", employee.getLastName());
    emp1.append("location", employee.getLocation());

    String response = null;
    try {
      BasicDBObject filter = new BasicDBObject("_id",new ObjectId(employee.getId()));
      collection.updateOne(filter, new BasicDBObject("$set", emp1));
      response = "successfully updated";
    } catch (Exception e) {
      response = "Something wnet wrong";
    }

    return response;
  }

  public String delete(String id) {
    MongoClient mongoClient = getClient();
    MongoDatabase database = mongoClient.getDatabase("test");
    MongoCollection<Document> collection = database.getCollection("employee");

    String response = null;
    try {
      BasicDBObject filter = new BasicDBObject("_id",new ObjectId(id));
      collection.deleteOne(filter);
      response = "successfully deleted";
    } catch (Exception e) {
      System.out.println(e);
      response = "Something wnet wrong";
    }

    return response;
  }
}
