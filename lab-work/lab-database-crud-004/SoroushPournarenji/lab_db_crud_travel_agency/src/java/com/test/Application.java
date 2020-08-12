package com.test;

import com.test.database.CRUD;
import com.test.database.TableGenerate;
import com.test.model.Flight;
import com.test.model.Person;

import java.io.IOException;
import java.sql.SQLException;

public class Application {
    public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException, IllegalAccessException {
        TableGenerate tableGenerate=new TableGenerate();
        tableGenerate.createTable(new Person());
        tableGenerate.createTable(new Flight());
        CRUD crud=new CRUD();
        crud.save(new Person(1l,"Hossen","karimi",32,"5447854756","Hossen@mail.com","123"));
        crud.save(new Person(2l,"Neda","Ahmadi",25,"0021457896","Neda@mail.com","abc"));
        crud.save(new Person(3l,"Sina","Alipour",18,"0025478647","Sina@mail.com","789"));
        crud.save(new Person(4l,"Mahsa","Nassirian",40,"3247547457","Mahsa@mail.com","def"));
        crud.save(new Flight(1l,"Airline",700,"First Class",1,"Tehran","Shiraz",10));
        crud.save(new Flight(2l,"Airline",900,"First Class",0,"Tehran","Kish",0));
        crud.save(new Flight(3l,"Airline",500,"Business Class",1,"Tehran","Tabriz",8));
        crud.save(new Flight(4l,"Airline",200,"Economy Class",1,"Tehran","Mashhad",3));
        crud.save(new Flight(5l,"Airline",400,"Economy Class",0,"Tehran","Shiraz",0));
        crud.update(new Person(1l,"Reza","Hosseinzadeh",20,"0015472458","Reza@mail.com","456"));

    }
}
