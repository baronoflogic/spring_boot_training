package com.sumantra.springboot.controller;


import com.sumantra.springboot.entities.User;
import com.sumantra.springboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping(path = "/add")
    public @ResponseBody ResponseEntity<User> addNewUser(@RequestParam("name") String name, @RequestParam("email") String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> fetchAllUsers(){
        return userRepository.findAll();
    }

}
