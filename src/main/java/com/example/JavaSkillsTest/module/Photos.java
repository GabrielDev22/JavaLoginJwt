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
@Table(name = "photos")
public class Photos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer albumId;
    private String title;
    private String url;
    private String thumbanailUrl;


}
