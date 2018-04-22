package com.md.web;

import com.md.model.User;
import com.md.service.UserService;
import com.md.service.CustomerRepository;
import com.md.service.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController("/user")
public class UserController implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @RequestMapping(value = "/welcomeUser", method = RequestMethod.GET)
    public String welcome() {
        return "Service works properly";
    }

    @Override
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
    public ResponseEntity<User> addUser(@RequestBody User user) {

        User currentUser = new User.Builder()
                .login(user.getLogin())
                .password(user.getPassword())
                .pesel(user.getPesel())
                .build();

        return new ResponseEntity<>(userRepository.save(currentUser), HttpStatus.CREATED);
    }

    @Override
    @RequestMapping(value = "getUsers", method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> getAllUsers() {

        Collection<User> response = userRepository.findAll();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserById(@PathVariable long id) {

        User response = userRepository.findOne(id);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "updateUser/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user) {

        User currentUser = userRepository.findOne(id);

        currentUser.setLogin(user.getLogin());
        currentUser.setPassword(user.getPassword());
        currentUser.setPesel(user.getPesel());

        User response = userRepository.save(currentUser);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    @RequestMapping(value = "deleteUser/{id}", method = RequestMethod.DELETE)
    public void deleteUserById(@PathVariable long id) {
        userRepository.delete(id);
    }

    @Override
    @RequestMapping(value = "deleteUsers", method = RequestMethod.DELETE)
    public void deleteAll() {
        userRepository.deleteAll();
    }
}
