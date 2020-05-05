package com.example.mongodb.resource;

import com.example.mongodb.document.Users;
import com.example.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/users")
public class UsersResource {
  @Autowired
  private UserRepository userRepository;

  @GetMapping("/all")
  public List<Users> getAll() {
    return userRepository.findAll();
  }
}
