package com.example.JavaSkillsTest.controller;


import com.example.JavaSkillsTest.module.Todos;
import com.example.JavaSkillsTest.service.TodosService;
import com.example.JavaSkillsTest.service.implementation.TodosServiceImplementation;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
public class TodosController {

    @Autowired
    TodosService todosService;

    @GetMapping("/getAll")
    public List<Todos> getAllTodos(){
        return todosService.getAllTodos();
    }

    @GetMapping("/get/{id}")
    public Todos getTodosById(@PathVariable Integer id){
        return todosService.getTodosById(id);
    }

    @GetMapping("/gettwo/letter")
    public List<Todos> getTodosTwoLetter(){
        return todosService.getTodosTwoLetter();
    }

    @GetMapping("/getfilter/range")
    public List<Todos> getTodosFilterRange(){
        return todosService.getTodosFilterRange();
    }

    @GetMapping("/getfilter/body")
    public List<Todos> getTodosFilterBody(){
        return todosService.getTodosFilterBody();
    }

    @PostMapping("/create")
    public List<Todos> createTodos(@RequestBody List<Todos> todos){
        return todosService.createTodos(todos);
    }

    @PutMapping("/update")
    public Todos updateTodos(@RequestBody Todos todos){
        return todosService.updateTodos(todos);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllTodos(){
        todosService.deleteAllTodos();
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        todosService.deleteTodosById(id);
    }


}
