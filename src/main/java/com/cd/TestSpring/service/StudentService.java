package com.cd.TestSpring.service;

import com.cd.TestSpring.entity.StudentEntry;
import com.cd.TestSpring.repository.StudentRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveEntry(StudentEntry studentEntry){
        studentRepository.save(studentEntry);
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
