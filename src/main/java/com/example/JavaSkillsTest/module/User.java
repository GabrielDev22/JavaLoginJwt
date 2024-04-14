package com.example.JavaSkillsTest.module;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@NoArgsConstructor
@Data
@Entity
@Table(name = "usuarios")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Number postId;
    private String name;
    private String email;
    @Column(columnDefinition = "TEXT")
    private String body;



}
