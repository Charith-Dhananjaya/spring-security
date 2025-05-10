package com.cd.TestSpring.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckGet {

    @GetMapping("/check")
    public String checkGet(){
        return "ok";
    }
}
