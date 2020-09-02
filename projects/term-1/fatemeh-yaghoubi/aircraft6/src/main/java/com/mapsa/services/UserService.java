package com.mapsa.services;

import com.mapsa.dao.UserDao;
import com.mapsa.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserDao userDao;
    public User getUserById(int id) {
        User user = userDao.getUserById(id);
        return user;

    }

    public User getUserByUsername(String username) {
        User user = userDao.getUserByUsername(username);
        return user;

    }


}