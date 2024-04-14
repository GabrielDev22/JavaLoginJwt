package com.example.JavaSkillsTest.module;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "myusers")
@Accessors(chain = true)
public class MyUsers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String username;
    private String email;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Config address;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Geo geo;
    private String phone;
    private String website;
    @JdbcTypeCode(SqlTypes.JSON)
    @Column(columnDefinition = "jsonb")
    private Company company;

    @Data
    @Accessors(chain = true)
    public static class Config implements Serializable{
        private String street;
        private String suite;
        private String city;
        private String zipcode;
    }

    @Data
    @Accessors(chain = true)
    public static class Geo implements Serializable{
        private String lat;
        private String lng;
    }

    @Data
    @Accessors(chain = true)
    public static class Company implements Serializable{
        private String name;
        private String catchPhrase;
        private String bs;
    }

}
