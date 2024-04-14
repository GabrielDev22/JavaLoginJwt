package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.Albums;
import com.example.JavaSkillsTest.module.Photos;
import com.example.JavaSkillsTest.module.User;
import com.example.JavaSkillsTest.repository.AlbumsRepository;
import com.example.JavaSkillsTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataUserAndAlbumsServiceImplementation {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AlbumsRepository albumsRepository;

    public List<Object> getMixDataUserAndAlbums(){
        List<Object> getMixDataResources = new ArrayList<>();

        getMixDataResources.addAll(userRepository.findAll());
        getMixDataResources.addAll(albumsRepository.findAll());

        List<Object> getResultData = new ArrayList<>();
        for(Object resource : getMixDataResources){
            try{
                if(resource instanceof User){
                    User user = (User) resource;
                    if(user.getEmail().endsWith("com")){
                        getResultData.add(user);
                    }
                }

                if(resource instanceof Albums){
                    Albums albums = (Albums) resource;
                    if(albums.getId() == 1){
                        getResultData.add(albums);
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return getResultData;
    }
}
