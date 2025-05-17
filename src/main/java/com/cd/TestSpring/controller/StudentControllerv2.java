package com.cd.TestSpring.controller;

import com.cd.TestSpring.entity.StudentEntry;
import com.cd.TestSpring.service.StudentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<StudentEntry> getEntryById(@PathVariable ObjectId myId) {
        Optional<StudentEntry> studentEntry = studentService.findById(myId);
        if(studentEntry.isPresent()){
            return  new ResponseEntity<>(studentEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
