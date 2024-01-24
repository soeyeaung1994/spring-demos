package com.demo.snap.aop;

/**
 * @Author: Soe Ye Aung
 * @Date: 24/1/24
 * @Time: 1:43 am
 */

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class SnapLoggingAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.demo.snap.*.*.*(..))")
    public void logBeforeMethod(JoinPoint joinpoint) {
        logger.info("Start:: {} is called with Parameters: {}", joinpoint.getSignature(), joinpoint.getArgs());
    }

    @After("execution(* com.demo.snap.*.*.*(..))")
    public void logAfterMethod(JoinPoint joinPoint) {
        logger.info("End:: {} is called with Parameters: {}", joinPoint.getSignature(), joinPoint.getArgs());
    }

}
