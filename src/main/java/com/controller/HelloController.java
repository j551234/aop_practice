package com.controller;

import com.annotation.Action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    @Action("dohello")
    public String hello() {
        return "Hello Spring Boot is using the aop";
    }

    @RequestMapping("/show")
    @Action(value = "show gg")
    public String index() {
        return " i am the action ";
    }

    @RequestMapping("/123")
    @Action(value = "show gg")
    public String oneTwoThree() {
        return " say one two three";
    }
}