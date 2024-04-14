package com.example.JavaSkillsTest.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"username", "message", "status"})
public class AuthResponse {

    private String username;
    private String message;
    private String jwt;
    private boolean status;

}
