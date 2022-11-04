package com.project.test.controller;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.test.entity.User;
import com.project.test.repository.UserRepository;
import com.project.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/users")

public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAllUser() {
        return userService.findAllUser();
    }

    @GetMapping("/{id}")
    public Optional<User> findUserById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }


    @JsonIgnore
    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User saveUser= userService.saveUser(user);
        return new ResponseEntity<User>(saveUser, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public User updateUser(@RequestBody User user,@PathVariable("id") Long id) {
        return userService.updateUser(user,id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        return userService.deleteUser(id);
    }

}
