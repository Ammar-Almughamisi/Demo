package com.ammar.database;

import org.springframework.stereotype.Component;

@Component
public class Aop {
    private String name;

    public void addAccount() {
        System.out.println("testing AOP");
    }

    public String getName() {
        return "this is the get method";
    }

    public void addLogin() {
        System.out.println("this is the login page");
    }
}
