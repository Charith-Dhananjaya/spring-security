package com.cd.TestSpring.service;

import com.cd.TestSpring.entity.StudentEntry;
import com.cd.TestSpring.repository.StudentRepository;
import com.cd.TestSpring.service.UserService;
import com.cd.TestSpring.entity.Users;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private UserService userService;

    public void saveEntry(StudentEntry studentEntry , String userName){
        Users user = userService.findByUserName(userName);
        studentEntry.setDate(LocalDateTime.now());
        StudentEntry saved = studentRepository.save(studentEntry);
        user.getStudentEntries().add(saved);
        userService.saveEntry(user);
    }

    public List<StudentEntry> getAll(){
        return studentRepository.findAll();
    }

    public Optional<StudentEntry> findById(ObjectId id){
        return studentRepository.findById(id);
    }

    public void deleteById(ObjectId id){
        studentRepository.deleteById(id);
    }
}
