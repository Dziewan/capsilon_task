package com.md.service;

import com.md.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface UserService {

    ResponseEntity<User> addUser(User user);

    ResponseEntity<User> getUserById(long id);

    ResponseEntity<User> updateUser(long id, User user);

    ResponseEntity<Collection<User>> getAllUsers();

    String welcome();

    void deleteUserById(long id);

    void deleteAll();
}
