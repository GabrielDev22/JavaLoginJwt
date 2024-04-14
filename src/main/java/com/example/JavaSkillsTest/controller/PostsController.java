package com.example.JavaSkillsTest.controller;


import com.example.JavaSkillsTest.module.Posts;
import com.example.JavaSkillsTest.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostsController {

    @Autowired
    private PostsService postsService;

    @GetMapping("/getAll")
    public List<Posts> getAllPosts(){
        return postsService.getAllPosts();
    }

    @GetMapping("/getfilter/forp")
    public List<Posts> getPostsWithLetterP(){
        return postsService.getPostsWithLetterP();
    }

    @GetMapping("/getfilter/maxlength50")
    public List<Posts> getPostsMaxLength50(){
        return postsService.getPostsMaxLength50();
    }

    @GetMapping("/getfilter/bodypost")
    public ResponseEntity<List<Posts>> getPostsFilterBody(){
        return postsService.getPostsFilterBody();
    }

    @GetMapping("/get/{id}")
    public Posts getPostsById(@PathVariable  Integer id){
        return postsService.getPostsById(id);
    }

    @PostMapping("/create")
    public List<Posts> createPosts(@RequestBody List<Posts> posts){
        return postsService.createPost(posts);
    }

    @PutMapping("/update")
    public Posts updatePost(@RequestBody Posts posts){
        return postsService.updatePosts(posts);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePostById(@PathVariable Integer id){
         postsService.deletePostsById(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAllPosts(){
        postsService.deleteAllPost();
    }




}
