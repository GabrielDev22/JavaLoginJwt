package com.example.JavaSkillsTest.repository;

import com.example.JavaSkillsTest.model.UsuarioApp;
import com.example.JavaSkillsTest.module.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAppRepository extends JpaRepository<UsuarioApp, Integer> {

    Optional<UsuarioApp> findUserAppByUsername(String username);

    @Query("SELECT u FROM UsuarioApp u WHERE u.username = :username")
    Optional<UsuarioApp> findUser(@Param("username") String username);

}
