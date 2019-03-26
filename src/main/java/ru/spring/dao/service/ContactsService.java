package ru.spring.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.spring.dao.interfaces.ContactsDao;
import ru.spring.dao.objects.Contacts;

import java.util.List;

@Service
public class ContactsService implements IContactsService {

    @Autowired
    ContactsDao contactsDao;

    @Override
    public Contacts getContactsByID(int id) {
        return contactsDao.getContactsByID(id);
    }

    @Override
    public void insert(Contacts contacts) {
        contactsDao.insert(contacts);
    }

    @Override
    public void delete(int id) {
        contactsDao.delete(id);
    }

    @Override
    public List<Contacts> getContactsListAll() {
        return contactsDao.getContactsListAll();
    }
}
