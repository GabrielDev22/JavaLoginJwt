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
@Table(name = "albums")
public class Albums {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer userId;
    private Integer id;
    private String title;

}
