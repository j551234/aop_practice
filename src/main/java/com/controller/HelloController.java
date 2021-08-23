package com.controller;

import com.annotation.Action;
import com.service.DoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    DoService doService;
    @Autowired
    HelloController(){
        this.doService= doService;
    }



    @RequestMapping("/")
    @Action
    public String hello() {
        System.out.println("Hello Spring Boot is using the aop");
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

    @GetMapping(value = "/message")
    public String getMessage() {
        String message = "show me the message ";
        System.out.println("MessageController.getMessage():" + message);
        return message;
    }

    @GetMapping("aaa")
    public String sayA() {
        return doService.sayHi();
    }


}