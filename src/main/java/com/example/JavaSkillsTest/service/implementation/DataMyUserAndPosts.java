package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.MyUsers;
import com.example.JavaSkillsTest.module.Posts;
import com.example.JavaSkillsTest.repository.MyUserRepository;
import com.example.JavaSkillsTest.repository.PostsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DataMyUserAndPosts {

    @Autowired
    private MyUserRepository myUserRepository;
    @Autowired
    private PostsRepository postsRepository;

    public List<Object> mixDataTwoTables(){
        List<Object[]> resultados = new ArrayList<>();

        resultados.add(myUserRepository.findAll().toArray());
        resultados.add(postsRepository.findAll().toArray());

        List<Object> getMixDataResult = new ArrayList<>();
        for(Object[] resultado : resultados){
            for(Object object : resultado){
                try{
                    if(object instanceof MyUsers){
                        MyUsers myUsers = (MyUsers) object;
                        if(myUsers.getId() >= 4 && myUsers.getId() <= 8){
                            getMixDataResult.add(myUsers);
                        }
                    }

                    if(object instanceof Posts){
                        Posts posts = (Posts) object;
                        if(posts.getBody() != null && posts.getBody().length() > 200){
                            getMixDataResult.add(posts);
                        }
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }

        return Collections.singletonList(getMixDataResult);
    }


}
