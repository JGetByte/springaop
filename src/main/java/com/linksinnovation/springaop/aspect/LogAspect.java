/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.linksinnovation.springaop.aspect;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 *
 * @author Jirawong Wongdokpuang <jirawong@linksinnovation.com>
 */
@Aspect
public class LogAspect {
    
    @Pointcut("execution(* set*(..))")
    public void simpleService(){
        
    }
    
    @Pointcut("execution(* get*(..))")
    public void simpleServiceGet(){
        
    }
    
    @Before("simpleService()")
    public void beforeSet(JoinPoint jp){
        System.out.println("before calll setter" + Arrays.toString(jp.getArgs()));
    }
    
    @After("simpleService()")
    public void afterSet(JoinPoint jp){
        System.out.println("after call setter "+ jp.getSignature().getName());
    }
    
    @AfterReturning(pointcut = "simpleServiceGet()",returning = "result")
    public void afterReturnSet(JoinPoint jp, Object result){
        System.out.println("after return " +result);
    }
    
    @AfterThrowing(pointcut = "simpleService()",throwing = "err")
    public void afterThrowSet(JoinPoint jp , Throwable err){
        System.out.println("after throw "+err.getMessage());
    }
    
    @Around("simpleService()")
    public Object aroundSet(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("before");
        
        String x[] = new String[]{"xxxx"};
        
        
        Object proceed = pjp.proceed(x);
        System.out.println("after");
        return proceed;
    }
}
