package com.example.JavaSkillsTest.module;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Entity
@Component
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "todos")
public class Todos {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;
    private Integer userId;
    private String title;
    private boolean completed;

}
