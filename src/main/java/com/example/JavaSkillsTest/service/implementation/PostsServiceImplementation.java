package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.Posts;
import com.example.JavaSkillsTest.repository.PostsRepository;
import com.example.JavaSkillsTest.service.PostsService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PostsServiceImplementation implements PostsService {

    @Autowired
    private PostsRepository postsRepository;


    @Override
    public List<Posts> getAllPosts() {
        List<Posts> allUser = null;
        try{
            allUser = postsRepository.findAll();
            if(allUser.isEmpty()){
                return null;
            }
            return allUser;
        }catch (Exception e){
            e.printStackTrace();
        }
        return allUser;
    }

    @Override
    public List<Posts> getPostsWithLetterP() {
        List<Posts> getPostsLetterP = new ArrayList<>();
        try{
            List<Posts> getPostsP = postsRepository.findAll();
            for(Posts post : getPostsP){
                if(post.getTitle().toLowerCase().startsWith("p")){
                    getPostsLetterP.add(post);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getPostsLetterP;
    }

    @Override
    public List<Posts> getPostsMaxLength50() {
        List<Posts> postsMaxLength = new ArrayList<>();
        try{
            List<Posts> getPostsMaxLength = postsRepository.findAll();
            for (Posts post : getPostsMaxLength){
                if(post.getTitle().length() > 50){
                    postsMaxLength.add(post);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return postsMaxLength;
    }

    @Override
    public ResponseEntity<List<Posts>> getPostsFilterBody() {
        List<Posts> postsFiltersBody = new ArrayList<>();
        try{
            List<Posts> getPotsFiltersBody = postsRepository.findAll();
            for(Posts posts : getPotsFiltersBody){
                if(posts.getBody().length() > 70 && posts.getTitle().toLowerCase().startsWith("s") || posts.getTitle().toLowerCase().startsWith("e")){
                    postsFiltersBody.add(posts);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResponseEntity.ok(postsFiltersBody);
    }

    @Override
    public Posts getPostsById(Integer id) {
        Posts postById = null;
        try{
            postById = postsRepository.getReferenceById(id);
            if(postById.getId() == null){
                return null;
            }
            return postById;
        }catch (Exception e){
            e.printStackTrace();
        }
        return postById;
    }

    @Override
    public List<Posts> createPost(List<Posts> posts) {
        List<Posts> createPosts = new ArrayList<>();
        for(Posts post : posts){
            Posts createPost = postsRepository.save(post);
            createPosts.add(createPost);
        }
        return createPosts;
    }

    @Override
    public Posts updatePosts(Posts posts) {
         Posts updatePosts = null;
         try{
             updatePosts = postsRepository.save(posts);
             if(!StringUtils.hasText(posts.getBody()) && !StringUtils.hasText(posts.getTitle())){
                 return updatePosts;
             }
         }catch (Exception e){
             e.printStackTrace();
         }

        return updatePosts;
    }

    @Override
    public void deletePostsById(Integer id) {
        postsRepository.deleteById(id);
    }

    @Override
    public void deleteAllPost() {
        postsRepository.deleteAll();
    }

}
