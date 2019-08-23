package com.controller;

import com.annotation.Action;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/")
    @Action("hello")
    public String hello() {
        return "Hello Spring Boot is using the aop";
    }
    @RequestMapping("/index")
    @ResponseBody
    public String index() {
    	return " index is using  the filter";
    }
}