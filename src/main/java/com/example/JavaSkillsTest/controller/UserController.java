package com.example.JavaSkillsTest.controller;


import com.example.JavaSkillsTest.module.User;
import com.example.JavaSkillsTest.service.UserService;
import com.example.JavaSkillsTest.service.implementation.UsersOnlyForOneLetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UserController {

    @Autowired
    UsersOnlyForOneLetterService usersOnlyForOneLetterService;

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAllUser(){
        return  userService.getAllUser();
    }

    @GetMapping("/get/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }

    @GetMapping("/getForL")
    public ResponseEntity<List<User>> findUsersWithLetterL(){
        List<User> userResponses = usersOnlyForOneLetterService.findUsersWithLetterL();
        return ResponseEntity.ok(userResponses);
    }

    @GetMapping("/searchForLetter")
    public ResponseEntity<List<User>> getUsersWithNameStartingWith(){
        List<User> users = usersOnlyForOneLetterService.searchUsersWhoStartByLetter();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/searchForPrefix")
    public ResponseEntity<List<User>> getUsersWithNameStartingWithLAndN(){
        List<User> users = usersOnlyForOneLetterService.buscarNombresComenzandoConLN();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/searchSinQuery")
    public ResponseEntity<List<User>> getUserDataBase(){
        List<User> users = usersOnlyForOneLetterService.filtrarNombresBaseDeDatos();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/create")
    public List<User> createUser(@RequestBody List<User> user){
        return userService.createUser(user);
    }

    @PutMapping("/update")
    public  User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUserById(@PathVariable Integer id){
        userService.deleteUserById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteUserAll(){
        userService.deleteUserAll();
    }

}
