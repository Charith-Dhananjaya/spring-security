package com.cd.TestSpring.controller;
import com.cd.TestSpring.entity.checkEntry;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/rest")
public class MyController {

    private Map<Long,checkEntry> checkEntries =  new HashMap<>();

    @GetMapping("get")
    public List<checkEntry> getAll(){
        return  new ArrayList<>(checkEntries.values());
    }

    @PostMapping("post")
    public checkEntry createEntry(@RequestBody checkEntry myEntry){
            checkEntries.put(myEntry.getId(), myEntry);
            return myEntry;
    }

    @GetMapping("id/{myId}")
    public checkEntry getEntryById(@PathVariable Long myId){
        return  checkEntries.get(myId);
    }

    @DeleteMapping("id/{myId}")
        public checkEntry deleteEntryById(@PathVariable Long myId){
            return checkEntries.remove(myId);
        }

    @PutMapping("id/{id}")
    public  checkEntry updateEntryById(@PathVariable Long id, @RequestBody checkEntry myEntry){
        return  checkEntries.put(id, myEntry);
    }
}
