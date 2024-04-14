package com.example.JavaSkillsTest.service;

import com.example.JavaSkillsTest.module.Todos;

import java.util.List;

public interface TodosService {
    List<Todos> getAllTodos();

    List<Todos> getTodosTwoLetter();
    List<Todos> getTodosFilterRange();
    List<Todos> getTodosFilterBody();
    Todos getTodosById(Integer id);
    List<Todos> createTodos(List<Todos> todos);
    Todos updateTodos(Todos todos);
    void deleteAllTodos();
    void deleteTodosById(Integer id);

}
