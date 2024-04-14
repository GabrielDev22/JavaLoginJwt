package com.example.JavaSkillsTest.controller;

import com.example.JavaSkillsTest.model.AuthCreateUserRequest;
import com.example.JavaSkillsTest.model.AuthLoginRequest;
import com.example.JavaSkillsTest.model.AuthResponse;
import com.example.JavaSkillsTest.service.implementation.UserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailServiceImpl userDetailsServiceImpl;

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody  AuthLoginRequest userRequest){
        return new ResponseEntity<>(this.userDetailsServiceImpl.loginUser(userRequest), HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<AuthResponse> create(@RequestBody AuthCreateUserRequest authCreateUserRequest) throws IllegalAccessException {
        return new ResponseEntity<>(this.userDetailsServiceImpl.createUser(authCreateUserRequest), HttpStatus.OK);
    }

}
