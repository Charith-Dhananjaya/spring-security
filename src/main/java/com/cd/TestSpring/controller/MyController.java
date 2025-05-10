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

    @GetMapping
    public List<checkEntry> getAll(){
        return  new ArrayList<>(checkEntries.values());
    }

    @PostMapping
    public boolean createEntry(@RequestBody checkEntry myEntry){
            checkEntries.put(myEntry.getId(), myEntry);
            return true;
    }
}
