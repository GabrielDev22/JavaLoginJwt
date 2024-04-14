package com.example.JavaSkillsTest.repository;

import com.example.JavaSkillsTest.module.MyUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

@Repository
public interface MyUserRepository extends JpaRepository<MyUsers, Integer> {

}
