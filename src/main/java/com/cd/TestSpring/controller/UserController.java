package com.cd.TestSpring.controller;

import com.cd.TestSpring.entity.Users;
import com.cd.TestSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<Users> getAllUsers(){
        return userService.getAll();
    }

    @PostMapping
    public Users createUser(@RequestBody Users user){
        userService.saveEntry(user);
        return user;
    }

    @PutMapping
    public ResponseEntity<?> updateUser(@RequestBody Users user){
        Users userInDb = userService.findByUserName(user.getUserName());
        if(userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

