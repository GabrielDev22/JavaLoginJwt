package com.example.JavaSkillsTest.controller;

import com.example.JavaSkillsTest.service.implementation.DataMyUserAndPosts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataMyUserAndPostController {

    @Autowired
    private DataMyUserAndPosts dataMyUserAndPosts;

    @GetMapping("/getMix/userandpost")
    public List<Object> mixDataTwoTables(){
        return dataMyUserAndPosts.mixDataTwoTables();
    }


}
