package com.service;

import org.springframework.stereotype.Service;

@Service
public class DoService {
    public String sayHi() {
        System.out.println("hello i am function sayHi");
        return "hello i am function sayHi";
    }
}
