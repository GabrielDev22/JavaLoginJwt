package com.example.JavaSkillsTest.service;

import com.example.JavaSkillsTest.module.MyUsers;

import java.util.List;

public interface MyUserService {

    List<MyUsers> getAllMyUser();

    List<MyUsers> getMyUserRangeValores();
    List<MyUsers> getMyUserFilterForLetter();
    List<MyUsers> getMyUserFilterFullBody();
    MyUsers getByIdMyUser(Integer id);
    List<MyUsers> createMyUserAll(List<MyUsers> myUsers);
    MyUsers createMyUser(MyUsers myUsers);
    MyUsers updateMyUser(MyUsers myUsers);
    void deleteMyUserAll();
    void deleteByIdMyUser(Integer id);

}
