package com.example.mongodb.config;

import com.example.mongodb.document.Users;
import com.example.mongodb.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfig {
  @Bean
  CommandLineRunner commandLineRunner(UserRepository userRepository) {
    return  new CommandLineRunner() {
      @Override
      public void run(String... args) throws Exception {
          userRepository.save(new Users(1, "Peter", "development", 3000L));
          userRepository.save(new Users(2, "Barry", "account", 1000L));
      }
    };
  }
}
