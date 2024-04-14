package com.example.JavaSkillsTest.service;

import com.example.JavaSkillsTest.module.User;

import java.util.List;

public interface UserService {

    List<User> getAllUser();
    User getUserById(Integer id);
     List<User> createUser(List<User> user);
     User updateUser(User user);
     void deleteUserById(Integer id);
     void deleteUserAll();

}
