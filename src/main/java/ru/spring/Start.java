package ru.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.spring.dao.impl.H2DaoImpl;
import ru.spring.dao.objects.Contacts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Start {

    public static void main(String[] args) {

        Contacts contacts = new Contacts();
        contacts.setName("name");
        contacts.setAuthor("author");

        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        H2DaoImpl h2Dao = (H2DaoImpl) context.getBean("h2DaoImpl");
        h2Dao.insert(contacts);

    }
}
