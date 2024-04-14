package com.example.JavaSkillsTest.repository;

import com.example.JavaSkillsTest.module.Albums;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumsRepository extends JpaRepository<Albums, Integer> {
}
