package com.example.demo;

import com.example.demo.Entities.User;

import java.util.List;
import java.util.Optional;


public interface UserService {

    Optional<User> getUserById(Long id);
    List<User> getAllUsers();

    User saveUser(User user);

    void deleteUserById(Long id);
   // List<User> findAll();
}
