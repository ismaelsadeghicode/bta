package com.mapsa.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;


@Aspect
@Component
public class SessionCheckAspect {

    @Autowired
    private HttpSession session;

    @Around("execution (public * com.mapsa.controller.UserPageController.*(..))")
    public Object isNullSession(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        if (session.getAttribute("accountId") != null) {
            return proceedingJoinPoint.proceed();
        } else {
            return "redirect:/";
        }

    }

}
