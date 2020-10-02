package com.mapsa.aop;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
    private static final Logger log = Logger.getLogger("\n===>" + LogAspect.class.getSimpleName());

    //log Controller
    @Pointcut("execution(public * com.mapsa.controller.*.*(..))")
    public void allMethodeInController() {
    }

    @Around("allMethodeInController()")
    public Object logAroundController(ProceedingJoinPoint proceedingJoinPoint) {
        log.info(String.format(
                "\n===>before::MethodeController",
                proceedingJoinPoint.getSignature().toString(),
                proceedingJoinPoint.getThis().getClass().getSimpleName()
        ));
        Object result = new Object();
        try {
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Throwable throwable) {
            log.error(String.format(
                    "\n===>::MethodeController::",
                    throwable.getMessage()
            ));
            throwable.printStackTrace();
        }
        log.info(String.format(
                "\n===>after::MethodeController",
                proceedingJoinPoint.getSignature().toString(),
                proceedingJoinPoint.getTarget().getClass().getSimpleName(),
                proceedingJoinPoint.getClass().getName()
        ));
        return result;
    }

    //log Dao
    @Pointcut("execution(public * com.mapsa.dao.*.*(..))")
    public void allMethodeInDao() {
    }

    @Around("allMethodeInDao()")
    public Object logAroundDao(ProceedingJoinPoint proceedingJoinPoint) {
        log.info(String.format(
                "\n===>before::MethodeDao",
                proceedingJoinPoint.getSignature().toString(),
                proceedingJoinPoint.getThis().getClass().getSimpleName()
        ));
        Object result = new Object();
        try {
            result = proceedingJoinPoint.proceed(proceedingJoinPoint.getArgs());
        } catch (Throwable throwable) {
            log.error(String.format(
                    "\n===>::MethodeDao::",
                    throwable.getMessage()
            ));
            throwable.printStackTrace();
        }
        log.info(String.format(
                "\n===>after::MethodeDao",
                proceedingJoinPoint.getSignature().toString(),
                proceedingJoinPoint.getTarget().getClass().getSimpleName(),
                proceedingJoinPoint.getClass().getName()
        ));
        return result;
    }


}
