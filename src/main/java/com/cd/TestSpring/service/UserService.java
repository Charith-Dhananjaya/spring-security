package com.cd.TestSpring.service;


import com.cd.TestSpring.entity.Users;
import com.cd.TestSpring.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Users saveEntry(Users studentEntry){
       return userRepository.save(studentEntry);
    }

    public List<Users> getAll(){
        return userRepository.findAll();
    }

    public Optional<Users> findById(ObjectId id){
        return userRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        userRepository.deleteById(id);
    }

    public Users findByUserName(String userName){
        return userRepository.findByUserName(userName);
    }
}
