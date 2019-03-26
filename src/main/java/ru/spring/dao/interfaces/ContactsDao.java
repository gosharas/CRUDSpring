package ru.spring.dao.interfaces;


import ru.spring.dao.objects.Contacts;

import java.util.List;

public interface ContactsDao {
    //create
    void create();

    //read
    Contacts getContactsByID(int id);

    //update
    void insert(Contacts contacts);

    //delete
    void delete(Contacts contacts);


    void deleteTable();
    List<Contacts> getContactsListAll();
}
