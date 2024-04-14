package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.Photos;
import com.example.JavaSkillsTest.module.Todos;
import com.example.JavaSkillsTest.repository.PhotosRepository;
import com.example.JavaSkillsTest.repository.TodosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataPhotosAndTodosServiceImplementation {

    @Autowired
    private PhotosRepository photosRepository;
    @Autowired
    private TodosRepository todosRepository;

    public List<Object> getMixDataPhotosAndTodos(){
        List<Object> resultMixDatas = new ArrayList<>();

        resultMixDatas.addAll(photosRepository.findAll());
        resultMixDatas.addAll(todosRepository.findAll());

        List<Object> getResultMixData = new ArrayList<>();
        for (Object resultMixData : resultMixDatas){
            try{
                if(resultMixData instanceof Photos){
                    Photos photos = (Photos) resultMixData;
                    if(photos.getAlbumId() == 1169){
                        getResultMixData.add(photos);
                    }
                }

                if(resultMixData instanceof Todos){
                    Todos todos = (Todos) resultMixData;
                    if(todos.isCompleted() && todos.getTitle().length() < 20){
                        getResultMixData.add(todos);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return getResultMixData;
    }


}
