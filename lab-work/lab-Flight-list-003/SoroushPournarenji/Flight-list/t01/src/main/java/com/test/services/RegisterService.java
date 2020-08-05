package com.test.services;

import com.test.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegisterService {
    public static Set<Person> people=new HashSet<>();
    public void addPeople(Person person){
        people.add(person);
    }
}
