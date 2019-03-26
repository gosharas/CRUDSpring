package ru.spring.dao.service;

import ru.spring.dao.objects.Contacts;

import java.util.List;

public interface IContactsService {

    Contacts getContactsByID(int id);

    void insert(Contacts contacts);

    void delete(int id);

    List<Contacts> getContactsListAll();
}
