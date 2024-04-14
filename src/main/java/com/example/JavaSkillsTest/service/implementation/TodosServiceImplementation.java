package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.Todos;
import com.example.JavaSkillsTest.repository.TodosRepository;
import com.example.JavaSkillsTest.service.TodosService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodosServiceImplementation implements TodosService {

    @Autowired
    private TodosRepository todosRepository;

    @Override
    public List<Todos> getAllTodos() {
        List<Todos> getAllTodos = null;
        try{
            getAllTodos = todosRepository.findAll();
            if(getAllTodos.isEmpty()){
                return null;
            }
            return getAllTodos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return getAllTodos;
    }

    @Override
    public List<Todos> getTodosTwoLetter() {
        List<Todos> getTodosTwoLetter = new ArrayList<>();
        try{
            List<Todos> postTodosTwoLetter = todosRepository.findAll();
            for (Todos todos : postTodosTwoLetter){
                if(todos.getTitle().toLowerCase().startsWith("d") || todos.getTitle().toLowerCase().startsWith("i")){
                     getTodosTwoLetter.add(todos);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getTodosTwoLetter;
    }

    @Override
    public List<Todos> getTodosFilterRange() {
        List<Todos> getTodosFilterRange = new ArrayList<>();
        try{
            try {
                List<Todos> postTodosFilterRange = todosRepository.findAll();
                for (Todos todos : postTodosFilterRange){
                    if(todos.getId() > 200 && todos.getId() < 300){
                        getTodosFilterRange.add(todos);
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getTodosFilterRange;
    }

    @Override
    public List<Todos> getTodosFilterBody() {
        List<Todos> getTodosBody = new ArrayList<>();
        try{
            List<Todos> postTodosBody = todosRepository.findAll();
            for (Todos todos : postTodosBody){
                if(todos.isCompleted() && todos.getId() > 255 && todos.getId() < 301 && todos.getTitle().length() > 10){
                    getTodosBody.add(todos);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getTodosBody;
    }

    @Override
    public Todos getTodosById(Integer id) {
        Todos getTodoById = null;
        try{
            getTodoById = todosRepository.getReferenceById(id);
            if(getTodoById.getId() == null){
                return null;
            }
            return getTodoById;
        }catch (Exception e){
            e.printStackTrace();
        }
        return getTodoById;
    }

    @Override
    public List<Todos> createTodos(List<Todos> todos) {
        List<Todos> createTodos = new ArrayList<>();
        try{
            for (Todos todo : todos){
                Todos createTodo = todosRepository.save(todo);
                createTodos.add(createTodo);
            }
            return createTodos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return createTodos;
    }

    @Override
    public Todos updateTodos(Todos todos) {
        Todos updateTodos = null;
        try{
            updateTodos = todosRepository.save(todos);
            if(!StringUtils.hasText(updateTodos.getTitle())){
                return null;
            }
            return updateTodos;
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateTodos;
    }

    @Override
    public void deleteAllTodos() {
        todosRepository.deleteAll();
    }

    @Override
    public void deleteTodosById(Integer id) {
        todosRepository.deleteById(id);
    }
}
