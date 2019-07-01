package com.ammar.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com/ammar/demo/ApplicationContext.xml");
        Coach theCoach = context.getBean("myCriecktCoach", Coach.class);
        System.out.println(theCoach.getDailyWorkOut());
        System.out.println(theCoach.getDailyFortune());
        context.close();

    }
}
