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
    public ResponseEntity<?> getAllData(){
        List<StudentEntry> all = studentService.getAll();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<StudentEntry> createEntry(@RequestBody StudentEntry myEntry) {
        try{
            myEntry.setDate(LocalDateTime.now());
            studentService.saveEntry(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<StudentEntry> getEntryById(@PathVariable ObjectId myId) {
        Optional<StudentEntry> studentEntry = studentService.findById(myId);
        if(studentEntry.isPresent()){
            return new ResponseEntity<>(studentEntry.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteEntryById(@PathVariable ObjectId myId) {
        studentService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<?> updateEntryById(@PathVariable ObjectId id, @RequestBody StudentEntry newEntry){
        StudentEntry oldEntry = studentService.findById(id).orElse(null);
        if(oldEntry != null){
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().equals("") ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setName(newEntry.getName() != null && !newEntry.getName().equals("") ? newEntry.getName() : oldEntry.getName());
            studentService.saveEntry(oldEntry);
            return new ResponseEntity<>(oldEntry, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
