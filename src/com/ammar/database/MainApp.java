package com.ammar.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Aop aop = context.getBean("aop", Aop.class);
        aop.addAccount();
        System.out.println("calling again");
        aop.addAccount();
        System.out.println("calling the getter method");
        System.out.println(aop.getName());
        System.out.println("calling the login methiod");
        aop.addLogin();
        context.close();
        Instructor instructor = new Instructor(1, "ammar", "Almughamisi", "ammar@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail(1, "ammar.com", "swimming");
        instructor.setForeignKey(instructorDetail);
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        try {
            instructorDetail = session.get(InstructorDetail.class, 1);
            instructor = instructorDetail.getInstructor();
            System.out.println(instructorDetail.getYoutubeChannel() + " " + instructorDetail.getHobby());
            System.out.println(instructor.getFirstName() + " " + instructor.getLastName() + " " + instructor.getEmail());
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            session.close();
            factory.close();
        }
        // session.save(instructor);
        //  session.getTransaction().commit();


    }

}
