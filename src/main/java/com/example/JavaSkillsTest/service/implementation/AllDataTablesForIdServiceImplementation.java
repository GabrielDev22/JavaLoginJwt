package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.*;
import com.example.JavaSkillsTest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class AllDataTablesForIdServiceImplementation {

    @Autowired
    private PostsRepository postsRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AlbumsRepository albumsRepository;
    @Autowired
    private PhotosRepository photosRepository;
    @Autowired
    private TodosRepository todosRepository;
    @Autowired
    private MyUserRepository myUserRepository;


    public List<Object> obtenerJsonWithId(){
        List<Object[]> resultados = new ArrayList<>();

        resultados.add(postsRepository.findAll().toArray());
        resultados.add(userRepository.findAll().toArray());
        resultados.add(albumsRepository.findAll().toArray());
        resultados.add(photosRepository.findAll().toArray());
        resultados.add(todosRepository.findAll().toArray());
        resultados.add(myUserRepository.findAll().toArray());

        List<Object> getMultiIdTables = new ArrayList<>();
        for (Object[] resultado : resultados){
            for (Object object : resultado){
                try{
                    Field idField = object.getClass().getDeclaredField("id");
                    idField.setAccessible(true);
                    int id = (int) idField.get(object);
                    if(id == 1){
                        getMultiIdTables.add(object);
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return Collections.singletonList(getMultiIdTables);
    }
}
