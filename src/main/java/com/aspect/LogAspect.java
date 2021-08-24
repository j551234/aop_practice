package com.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.annotation.Action;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 如果為aop的話
 * 仍會依照controller自行設定的路由繼續執行
 */
@Aspect
@Component
public class LogAspect {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 用法為
     *
     * @Pointcut("@annotation(自訂義annotation的class的位置)) 之後就在方法用@自訂義標籤來綁定這個aspect
     */


    @Pointcut("@annotation(com.annotation.Action)")
    public void log() {
    }

    @Around("log()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        System.out.println("aspect : around");
        System.out.println("aspect : process before");
        Object result = pjp.proceed();
        System.out.println("aspect : process after");
        return result;
    }


    @Before("log()")
    public void doBeforeController(JoinPoint joinPoint) {
        // see the joinPoint info
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        System.out.println("aspect : before");
        String class_name = joinPoint.getTarget().getClass().getName();
        String method_name = joinPoint.getSignature().getName();
        logger.info("class_name = {} start", class_name);
        logger.info("method_name = {} start ", method_name);

        Action action = method.getAnnotation(Action.class);
        logger.info(action.value() + " : function start");
    }

    @AfterReturning(pointcut = "log()", returning = "retValue")
    public void doAfterController(JoinPoint joinPoint, Object retValue) {
        System.out.println("aspect : after return");
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        String class_name = joinPoint.getTarget().getClass().getName();
        String method_name = joinPoint.getSignature().getName();
        logger.info("class_name = {} end", class_name);
        logger.info("method_name = {} end ", method_name);

        System.out.println("showScreen is:" + retValue);


    }


    @After("log()")
    public void after() {
        System.out.println("aspect : after");
    }

    @AfterThrowing(pointcut = "log()", throwing = "ex")
    public void doAfterException(Exception ex) {

        System.out.println("error is:" + ex);
    }

}