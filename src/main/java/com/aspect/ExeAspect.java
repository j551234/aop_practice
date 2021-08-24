package com.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExeAspect {
    @Pointcut("execution(* com.service.*.*(..)) ")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void sayHi() {
        System.out.println("aspect : before hi");
    }

    @After("pointCut()")
    public void sayEnd() {
        System.out.println("aspect : after hi");
    }

}
