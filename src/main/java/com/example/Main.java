package com.example;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import org.hibernate.Transaction;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        //Alien a=new Alien();

        //a.setId(101);
        //a.setName("Saadh");
        //a.setTech("Dev");

        // Alien a1=new Alien();

        // a1.setId(102);
        // a1.setName("Santhi");
        // a1.setTech("AiMl");

        // Alien a3=new Alien();

        // a3.setId(103);
        // a3.setName("Shiva");
        // a3.setTech("Auto");

        // Alien a2=new Alien();

        // a2.setId(104);
        // a2.setName("Sai");
        // a2.setTech("HR");

        Configuration config=new Configuration();
        config.addAnnotatedClass(com.example.Alien.class);
        config.configure("hibernate.cfg.xml"); //load the configuration
        SessionFactory factory = config.buildSessionFactory();
        Session session = factory.openSession();

        //Transaction transaction = session.beginTransaction();

        //session.persist(a1);

        //transaction.commit();


        //save the data in table
        //Transaction tx = session.beginTransaction();
        //session.persist(a1);
        //session.persist(a2);
        //session.persist(a3);
        //tx.commit();

        //select one row
        // Alien a2=session.find(Alien.class,104);
        // System.out.println(a2.getId()+" "+a2.getName()+" "+a2.getTech());

        //Select all data from table
        List<Alien> alien=session.createSelectionQuery("from Alien", Alien.class).getResultList();

        for(Alien a:alien){
            System.out.println(a.getId()+" "+a.getName()+" "+a.getTech());
        }

        //Update the data
        // Alien ua=session.find(Alien.class,104);
        // if(ua.getId()!=0){
        //     ua.setName("Abhishek");
        //     Transaction tx=session.beginTransaction();
        //     session.persist(ua);
        //     tx.commit();
        // }

        //remove one object
        //Transaction tx=session.beginTransaction();
        //Alien a2=session.find(Alien.class,104);
        // session.remove(a2);
        // tx.commit();

        session.close();
        factory.close();
    }
}