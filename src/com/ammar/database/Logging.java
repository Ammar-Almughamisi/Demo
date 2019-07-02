package com.ammar.database;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logging {
    @Pointcut("execution(* com.ammar.database.*.*())")
    private void forDataBasePackage() {
    }


    @Pointcut("execution(* com.ammar.database.*.get*(..))")
    private void forGetter() {
    }


    @Before("forDataBasePackage() && !forGetter()")
    public void beforeAddAccount() {
        System.out.println("this is the aspect method checking the security");
    }
}
