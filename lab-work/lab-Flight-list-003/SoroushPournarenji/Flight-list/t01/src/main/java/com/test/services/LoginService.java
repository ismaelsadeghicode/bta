package com.test.services;

import com.test.model.Person;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LoginService {

    public boolean isLogging(String username, String password) {

        for (Person p : RegisterService.people) {
            if (username.toLowerCase().equals(p.getEmail()) && p.checkPassword(password)) {
                return true;
            }
        }
        return false;
    }
}
