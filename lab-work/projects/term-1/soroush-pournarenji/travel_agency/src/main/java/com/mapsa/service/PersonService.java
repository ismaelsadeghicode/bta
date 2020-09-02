package com.mapsa.service;

import com.mapsa.dao.PersonDao;
import com.mapsa.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    PersonDao personDao;

    public void addPerson(Person person) {
        personDao.addPerson(person);
    }

    public Person addPersonToListPersonList(long accountId, Person person) {
        person.setAccountId(accountId);
        addPerson(person);
        return person;
    }

    public Person getPersonById(Long id) {
        return personDao.getPersonById(id);
    }

    public List<Person> findAllPeronByAccountId(long id) {
        return personDao.findAllPeronByAccountId(id);
    }
}
