package com.lm_api.librarymangementapi.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Slf4j
@Component
public class LoggingAspect {

    @Before("execution(* com.lm_api.librarymangementapi.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        log.info("Method started: {} ",joinPoint.getSignature().getName());
    }

    @After("execution(* com.lm_api.librarymangementapi.service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint){
        log.info("Method finished: {} ",joinPoint.getSignature().getName());
    }
}
