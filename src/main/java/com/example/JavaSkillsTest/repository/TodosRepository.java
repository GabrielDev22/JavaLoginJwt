package com.example.JavaSkillsTest.repository;

import com.example.JavaSkillsTest.module.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodosRepository extends JpaRepository<Todos, Integer> {
}
