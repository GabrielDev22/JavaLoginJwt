package com.example.JavaSkillsTest.repository;

import com.example.JavaSkillsTest.module.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Integer> {
}
