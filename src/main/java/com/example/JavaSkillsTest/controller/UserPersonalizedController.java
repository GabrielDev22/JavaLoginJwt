package com.example.JavaSkillsTest.controller;


import com.example.JavaSkillsTest.module.User;
import com.example.JavaSkillsTest.service.implementation.UsersOnlyForOneLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usersPersonalized")
public class UserPersonalizedController {

    @Autowired
    private UsersOnlyForOneLetterService usersOnlyForOneLetterService;

    @GetMapping("/getUsers/for/fifty")
    public ResponseEntity<List<User>> getUsersFromFiftyToOneHundred(){
        List<User> users = usersOnlyForOneLetterService.listadoDeCincuentaACien();
        return ResponseEntity.ok(users);
    }

}
