package com.example.JavaSkillsTest.repository;

import com.example.JavaSkillsTest.module.Photos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhotosRepository extends JpaRepository<Photos, Integer> {
}
