package ru.spring.dao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.spring.MyApplication;
import ru.spring.dao.impl.H2DaoImpl;
import ru.spring.dao.interfaces.ContactsDao;
import ru.spring.dao.objects.Contacts;
import ru.spring.dao.service.IContactsService;

import java.util.List;

@ComponentScan
@RestController
@RequestMapping("user/")
public class MainRestController {

    private IContactsService iContactsService;

    @GetMapping("contracts")
    public List<Contacts> getContractsListAll(){

        return iContactsService.getContactsListAll();
    }

    @RequestMapping(value = "lol", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }

    @RequestMapping(value = "delete" , method = RequestMethod.DELETE)
    public void delete(){
        iContactsService.delete(1);
    }
}
