package com.mapsa.dao;

import com.mapsa.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAllPerson();

    Person getPersonById(int id);

    void addPerson(Person person);

    void editPerson(Person person);

    void deletePerson(Person person);

    default void deletePersonById(int id){
        deletePerson(getPersonById(id));
    }

}
