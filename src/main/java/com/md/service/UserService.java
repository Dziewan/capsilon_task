package com.md.service;

import com.md.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Collection;

public interface ApiService {

    ResponseEntity<User> addState(User state);

    ResponseEntity<User> getPlayerById(long id);

    ResponseEntity<User> updatePlayerState(long id, User user);

    ResponseEntity<Collection<User>> getAll();

    String welcome();

    void deletePlayerStateById(long id);

    void deleteAll();
}
