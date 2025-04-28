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

    @GetMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<User> getUser(@PathVariable("id") int id){
        if(userRepository.findById(id).isPresent()){
            return new ResponseEntity<>(userRepository.findById(id).get(), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("email") String email){
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setId(id);
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<User> deleteUser(@PathVariable("id") int id){
        userRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
