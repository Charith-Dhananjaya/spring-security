package com.cd.TestSpring.service;

import com.cd.TestSpring.entity.StudentEntry;
import com.cd.TestSpring.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public void saveEntry(StudentEntry studentEntry){
        studentRepository.save(studentEntry);
    }
}
