package com.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.annotation.Action;
import org.springframework.stereotype.Component;
	/**
	 * 如果為aop的話
	 * 仍會依照controller自行設定的路由繼續執行
	 * */
@Aspect
@Component
public class LogAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 用法為
	 * @Pointcut("@annotation(自訂義annotation的class的位置))
	 * 之後就在方法用@自訂義標籤來綁定這個aspect
	 * */
    @Pointcut("@annotation(com.annotation.Action)")
    public void log() {
    	logger.info("function is runnig");
    }

    @Before("log()")
    public void doBeforeController(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        logger.info(action.value()  + "-function start");
    }
 
    @AfterReturning(pointcut = "log()", returning = "showScreen")
    public void doAfterController(JoinPoint joinPoint, Object showScreen) {
      
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Action action = method.getAnnotation(Action.class);
        System.out.println("showScreen is:" + showScreen);
        logger.info(action.value() + "-function end"); 
       
    }
}