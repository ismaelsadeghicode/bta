package com.mapsa.dao;

import com.mapsa.model.Person;

import java.util.List;

public interface PersonDao {
    List<Person> findAllPerson();

    Person getPersonById(long id);

    void addPerson(Person person);

    void editPerson(Person person);

    void deletePerson(Person person);
    List<Person> findAllPeronByAccountId(long id);

    default void deletePersonById(int id){
        deletePerson(getPersonById(id));
    }

}
