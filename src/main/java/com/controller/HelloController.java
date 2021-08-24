package com.controller;

import com.annotation.Action;
import com.service.DoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private DoService doService;

    @Autowired
    HelloController(DoService doService) {
        this.doService = doService;
    }

    // aop
    @RequestMapping("/")
    @Action
    public String hello() {
        System.out.println("Hello Spring Boot is using the aop");
        return "Hello Spring Boot is using the aop";
    }

    // aop annotation
    @RequestMapping("/show")
    @Action
    public String index() {
        return " i am the action ";
    }

    // filter
    @RequestMapping("/123")
    public String oneTwoThree() {
        return " say one two three";
    }

    // interceptor
    @GetMapping(value = "/message")
    public String getMessage() {
        String message = "show me the message ";
        System.out.println("MessageController.getMessage():" + message);
        return message;
    }

    // aop  service
    @GetMapping("/aaa")
    public String sayA() {
        return doService.sayHi();
    }


}