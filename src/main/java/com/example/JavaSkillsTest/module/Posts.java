package com.example.JavaSkillsTest.module;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "posts")
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer userId;
    private String title;
    private String body;

}
