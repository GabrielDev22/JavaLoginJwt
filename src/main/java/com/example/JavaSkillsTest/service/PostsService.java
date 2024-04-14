package com.example.JavaSkillsTest.service;

import com.example.JavaSkillsTest.module.Posts;
import com.example.JavaSkillsTest.module.Todos;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PostsService {

    List<Posts> getAllPosts();
    List<Posts> getPostsWithLetterP();
    List<Posts> getPostsMaxLength50();
    ResponseEntity<List<Posts>> getPostsFilterBody();
    Posts getPostsById(Integer id);
    List<Posts> createPost(List<Posts> posts);
    Posts updatePosts(Posts posts);
    void deletePostsById(Integer id);
    void deleteAllPost();

}
