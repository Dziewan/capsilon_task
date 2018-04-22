package com.md.web;

import com.md.model.User;
import com.md.service.ApiService;
import com.md.service.CustomerRepository;
import com.md.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class ApiController implements ApiService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    @RequestMapping(value = "welcome", method = RequestMethod.GET)
    public String welcome() {
        return "Inmobile service works properly";
    }

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> getAll() {

        Collection<User> response = repository.findAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getPlayerById(@PathVariable long id) {

        User response = repository.findOne(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> updatePlayerState(@PathVariable("id") long id, @RequestBody User user) {

        User currentUser = repository.findOne(id);
        currentUser.setState(user.getState());

        User response = repository.save(currentUser);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePlayerStateById(@PathVariable long id) {
        repository.delete(id);
    }

    @Override
    @RequestMapping(value = "/deleteAll", method = RequestMethod.DELETE)
    public void deleteAll() {
        repository.deleteAll();
    }

    @Override
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> addState(@RequestBody User user) {

        User currentUser = new User.Builder()
                .state(user.getState())
                .build();

//        return new ResponseEntity<>(repository.save(currentUser), HttpStatus.CREATED);
        return new ResponseEntity<>(currentUser, HttpStatus.CREATED);
    }
}
