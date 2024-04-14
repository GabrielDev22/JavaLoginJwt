package com.example.JavaSkillsTest.repository;

import com.example.JavaSkillsTest.model.RoleApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<RoleApp, Integer> {

    List<RoleApp> findRoleAppByRoleEnumIn(List<String> roleName);

}
