package com;

import com.service.DoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class AopApplicationTests {
    @Autowired
    DoService doService;

    @Test
    public void contextLoads() {

    }

    @Test
    void doTest() {
        doService.sayHi();
    }

}
