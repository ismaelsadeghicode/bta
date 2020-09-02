package com.mapsa.dao;

import java.util.List;
import com.mapsa.model.User;


public interface UserDao {

    List<User> findAllUsers();

    User getUserById(int id);

    User getUserByUsername(String username);

    void insertUser(User user);

    void updateUser(User user);

    void deleteUser(User user);


}