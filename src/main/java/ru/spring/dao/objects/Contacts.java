package ru.spring.dao.objects;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Contacts {


    private int id;
    private String name;
    private String author;

    public Contacts(int id, String name, String author) {

        this.id = id;
        this.name = name;
        this.author = author;
    }

    public Contacts() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
