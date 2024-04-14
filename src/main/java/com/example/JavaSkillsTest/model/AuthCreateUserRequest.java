package com.example.JavaSkillsTest.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthCreateUserRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

    @Valid
    @Size(max = 3, message = "The user cannot have more than 3 roles")
    private List<String> roleListName;

}
