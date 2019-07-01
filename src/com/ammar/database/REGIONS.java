package com.ammar.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "REGIONS")

public class REGIONS {
    @Id
    @Column(name = "REGION_ID")
    private int id;
    @Column(name = "REGION_NAME")
    private String regionName;

    public REGIONS() {

    }

    public REGIONS(int id, String regionName) {
        this.id = id;
        this.regionName = regionName;

    }

    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(REGIONS.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            //  Student tempStudent = session.get(Student.class, 4);
            List<REGIONS> regions = session.createQuery("from REGIONS where REGION_ID = 7").list();
            for (REGIONS region : regions) {
                System.out.println(region.id + " " + region.regionName);
            }
        } finally {
            factory.close();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", regionName='" + regionName + '\'' +
                '}';
    }
}
