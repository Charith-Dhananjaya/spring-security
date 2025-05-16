package com.cd.TestSpring.controller;

import com.cd.TestSpring.entity.StudentEntry;
import com.cd.TestSpring.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentControllerv2 {

    @Autowired
    private StudentService studentService;


    @GetMapping("get")
    public List<StudentEntry> getAllData(){
        return studentService.getAll();
    }

    @PostMapping
    public StudentEntry createEntry(@RequestBody StudentEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        studentService.saveEntry(myEntry);
        return myEntry;
    }

    @GetMapping("id/{myId}")
    public StudentEntry getEntryById(@PathVariable ObjectId myId) {
        return studentService.findById(myId).orElse(null);
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteEntryById(@PathVariable ObjectId myId) {
        studentService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{id}")
    public StudentEntry updateEntryById(@PathVariable ObjectId id, @RequestBody StudentEntry newEntry){
        StudentEntry oldEntry = studentService.findById(id).orElse(null);
        if(oldEntry != null){
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setName(newEntry.getName() != null && !newEntry.getName().equals("") ? newEntry.getName() : oldEntry.getName());

        }

        studentService.saveEntry(oldEntry);
        return oldEntry;
    }
}
