package ru.spring.dao.interfaces;


import ru.spring.dao.objects.Contacts;

import java.util.List;

public interface ContactsDao {
    //read
    Contacts getContactsByID(int id);

    //update
    void insert(Contacts contacts);

    //delete
    void delete(int id);

    List<Contacts> getContactsListAll();
}
