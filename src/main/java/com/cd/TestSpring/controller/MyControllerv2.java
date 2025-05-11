package com.cd.TestSpring.controller;

import com.cd.TestSpring.entity.checkEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/rest")
public class MyControllerv2 {



    @GetMapping("get")
    public List<checkEntry> getAll(){
        return null;
    }

    @PostMapping("post")
    public boolean createEntry(@RequestBody checkEntry myEntry){

            return true;
    }

    @GetMapping("id/{myId}")
    public checkEntry getEntryById(@PathVariable Long myId){
        return null;
    }

    @DeleteMapping("id/{myId}")
        public checkEntry deleteEntryById(@PathVariable Long myId){
        return null;
        }

    @PutMapping("id/{id}")
    public  checkEntry updateEntryById(@PathVariable Long id, @RequestBody checkEntry myEntry){
        return null;
    }
}
