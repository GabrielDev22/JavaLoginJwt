package com.example.JavaSkillsTest.repository;

import com.example.JavaSkillsTest.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByNameContainingIgnoreCase(String letter);

    List<User> findByNameStartingWithIgnoreCase(String letter);

    List<User> findByNameStartingWith(String prefix);

}
