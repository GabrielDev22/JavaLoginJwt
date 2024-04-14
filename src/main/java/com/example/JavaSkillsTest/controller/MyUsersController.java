package com.example.JavaSkillsTest.controller;

import com.example.JavaSkillsTest.module.MyUsers;
import com.example.JavaSkillsTest.repository.MyUserRepository;
import com.example.JavaSkillsTest.service.MyUserService;
import com.example.JavaSkillsTest.service.implementation.MyUserServiceImplementantion;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/myUser")
public class MyUsersController {


    private final MyUserServiceImplementantion myUserServiceImplementantion;

    @GetMapping("/getAll")
    public ResponseEntity<List<MyUsers>> getAllMyUser(){
        List<MyUsers> users = myUserServiceImplementantion.getAllMyUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/getrange/valores")
    public List<MyUsers> getMyUserRangeValores(){
        return myUserServiceImplementantion.getMyUserRangeValores();
    }

    @GetMapping("/getfilter/forletter")
    public List<MyUsers> getMyUserFilterForLetter(){
        return myUserServiceImplementantion.getMyUserFilterForLetter();
    }

    @GetMapping("/getfilter/fullbody")
    public List<MyUsers> getMyUserFilterFullBody(){
        return myUserServiceImplementantion.getMyUserFilterFullBody();
    }

    @GetMapping("/get/{id}")
    public MyUsers getByIdMyUser(@PathVariable Integer id){
        return myUserServiceImplementantion.getByIdMyUser(id);
    }

    @PostMapping("/createAll")
    public List<MyUsers> createMyUserAll(@RequestBody List<MyUsers> myUsers){
        return myUserServiceImplementantion.createMyUserAll(myUsers);
    }

    @PostMapping("/create")
    public MyUsers createMyUser(@RequestBody MyUsers myUsers){
        return myUserServiceImplementantion.createMyUser(myUsers);
    }

    @PutMapping("/update")
    public MyUsers updateMyUser(@RequestBody MyUsers myUsers){
        return myUserServiceImplementantion.updateMyUser(myUsers);
    }

    @DeleteMapping("/deleteAll")
    public void deleteMyUserAll(){
        myUserServiceImplementantion.deleteMyUserAll();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteByIdMyUser(@PathVariable Integer id){
        myUserServiceImplementantion.deleteByIdMyUser(id);
    }

}
