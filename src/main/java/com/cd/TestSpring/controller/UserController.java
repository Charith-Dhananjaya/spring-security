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

    @PutMapping("/{userName}")
    public ResponseEntity<Users> updateUser(@RequestBody Users user, @PathVariable String userName) {
        Users userInDb = userService.findByUserName(userName);
        if (userInDb != null) {
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            Users updatedUser = userService.saveEntry(userInDb);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


}

