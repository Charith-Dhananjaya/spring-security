package com.cd.TestSpring.controller;

import com.cd.TestSpring.entity.StudentEntry;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class StudentControllerv2 {



    @GetMapping("get")
    public List<StudentEntry> getAll(){
        return null;
    }

    @PostMapping("post")
    public boolean createEntry(@RequestBody StudentEntry myEntry){

            return true;
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
    public StudentEntry updateEntryById(@PathVariable String id, @RequestBody StudentEntry myEntry){
        return null;
    }
}
