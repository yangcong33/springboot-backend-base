package com.jacob.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SorryController {
    
    @GetMapping("/nyh_sry")
    public String sorry(){
        return "{\"status\": \"ok\",\"msg\": \"对不起对不起对不起~呜呜呜\"}";
    }
}
