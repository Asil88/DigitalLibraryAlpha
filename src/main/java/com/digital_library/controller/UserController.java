package com.digital_library.controller;


import com.digital_library.domain.Author;
import com.digital_library.domain.User;
import com.digital_library.service.AuthorService;
import com.digital_library.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public ResponseEntity<ArrayList<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user, user.getId() != 0 ? HttpStatus.OK : HttpStatus.CONFLICT);
    }

    @GetMapping("/start/{letter}")
    public ResponseEntity<User> getUserByFirstStartingWith(@PathVariable String letter) {
        return new ResponseEntity<>(userService.getUserByFirstStartingWith(letter), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> createUser(@RequestBody @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                logger.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<HttpStatus> updateUserById(@RequestBody User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            for (ObjectError o : bindingResult.getAllErrors()) {
                logger.warn(o.getDefaultMessage());
            }
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        userService.updateUserById(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@RequestBody @Valid User user) {
        userService.deleteUser(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/test")
    public ResponseEntity<HttpStatus> saveUserTransactional(@RequestBody User user) {
        userService.saveUserTransactional(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

