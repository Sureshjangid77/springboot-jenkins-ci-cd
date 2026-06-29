package com.bikkadit.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Testcontroller {

    @GetMapping("/")
    public String home() {
        return "checking for jenkins start automectically ";
    }
}
