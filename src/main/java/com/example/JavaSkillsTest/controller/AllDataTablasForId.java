package com.example.JavaSkillsTest.controller;

import com.example.JavaSkillsTest.service.implementation.AllDataTablesForIdServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/allData")
public class AllDataTablasForId {

    @Autowired
    private AllDataTablesForIdServiceImplementation allDataTablesForIdServiceImplementation;

    @GetMapping("/getFor/idOne")
    public List<Object> obtenerJsonWithId() {
        return allDataTablesForIdServiceImplementation.obtenerJsonWithId();
    }

}
