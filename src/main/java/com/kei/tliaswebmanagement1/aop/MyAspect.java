package com.kei.tliaswebmanagement1.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class MyAspect {
    /* 定义日志记录器*/
    private static final Logger logger = LoggerFactory.getLogger(MyAspect.class);

    /*定义公共切入点*/
    @Pointcut("execution(* com.kei.tliaswebmanagement1.controller.*.*(..))")
    public void publicPointcut() {}

    @Before("execution(* com.kei.tliaswebmanagement1.controller.*.*(..))")
    public void before() {
        logger.info("before ...");
    }

    @Around("execution(* com.kei.tliaswebmanagement1.controller.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        logger.info("around ... before ...");

        Object result = proceedingJoinPoint.proceed();

        logger.info("around ... after ...");

        return result;
    }

    @After("execution(* com.kei.tliaswebmanagement1.controller.*.*(..))")
    public void after() {
        logger.info("after ...");
    }

    @AfterReturning("execution(* com.kei.tliaswebmanagement1.controller.*.*(..))")
    public void afterReturning() {
        logger.info("afterReturning ...");
    }

    @AfterThrowing("execution(* com.kei.tliaswebmanagement1.controller.*.*(..))")
    public void afterThrowing() {
        logger.info("afterThrowing ...");
    }
}
