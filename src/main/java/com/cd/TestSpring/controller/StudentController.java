package com.cd.TestSpring.controller;
import com.cd.TestSpring.entity.StudentEntry;

import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/_rest")
public class StudentController {

    private Map<ObjectId, StudentEntry> studentEntries =  new HashMap<>();

    @GetMapping("get")
    public List<StudentEntry> getAll(){
        return  new ArrayList<>(studentEntries.values());
    }

    @PostMapping("post")
    public StudentEntry createEntry(@RequestBody StudentEntry studentEntry){
        studentEntries.put(studentEntry.getId(), studentEntry);
            return studentEntry;
    }

    @GetMapping("id/{myId}")
    public StudentEntry getEntryById(@PathVariable Long myId){
        return  studentEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
        public StudentEntry deleteEntryById(@PathVariable Long myId){
            return studentEntries.remove(myId);
        }

    @PutMapping("id/{id}")
    public StudentEntry updateEntryById(@PathVariable ObjectId id, @RequestBody StudentEntry myEntry){
        return  studentEntries.put(id, myEntry);
    }
}
