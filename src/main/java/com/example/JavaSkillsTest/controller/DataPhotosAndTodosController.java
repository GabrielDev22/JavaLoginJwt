package com.example.JavaSkillsTest.controller;

import com.example.JavaSkillsTest.service.implementation.DataPhotosAndTodosServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/datamix")
public class DataPhotosAndTodosController {

    @Autowired
    private DataPhotosAndTodosServiceImplementation dataPhotosAndTodosServiceImplementation;

    @GetMapping("/getmix/photosandtodos")
    public List<Object> getMixDataPhotosAndTodos(){
        return dataPhotosAndTodosServiceImplementation.getMixDataPhotosAndTodos();
    }

}
