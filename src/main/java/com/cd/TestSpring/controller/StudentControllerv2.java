package com.cd.TestSpring.controller;

import com.cd.TestSpring.entity.StudentEntry;
import com.cd.TestSpring.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentControllerv2 {

    @Autowired
    private StudentService studentService;


    @GetMapping("get")
    public List<StudentEntry> getAll(){
        return null;
    }

    @PostMapping
    public StudentEntry createEntry(@RequestBody StudentEntry studentEntry){
            studentService.saveEntry(studentEntry);
            return studentEntry;
    }

    @GetMapping("id/{myId}")
    public StudentEntry getEntryById(@PathVariable String myId){
        return null;
    }

    @DeleteMapping("id/{myId}")
        public StudentEntry deleteEntryById(@PathVariable String myId){
        return null;
        }

    @PutMapping("id/{id}")
    public StudentEntry updateEntryById(@PathVariable String id, @RequestBody StudentEntry studentEntry){
        return null;
    }
}
