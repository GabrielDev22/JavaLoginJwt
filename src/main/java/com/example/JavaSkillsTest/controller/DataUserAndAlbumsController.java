package com.example.JavaSkillsTest.controller;

import com.example.JavaSkillsTest.service.implementation.DataUserAndAlbumsServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/datamix")
public class DataUserAndAlbumsController {

    @Autowired
    private DataUserAndAlbumsServiceImplementation dataUserAndAlbumsServiceImplementation;

    @GetMapping("/getdata/userandalbums")
    public List<Object> getMixDataUserAndAlbums(){
        return dataUserAndAlbumsServiceImplementation.getMixDataUserAndAlbums();
    }

}
