package com.example.JavaSkillsTest.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "users_app")
public class UsuarioApp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String username;
    private String password;

    @Column(name = "is_enabled")
    private boolean isEnabled;
    @Column(name = "account_No_Expired")
    private boolean accountNoExpired;
    @Column(name = "account_No_Locked")
    private boolean accountNoLocked;
    @Column(name = "credential_No_Expired")
    private boolean credentialNoExpired;

   @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "usuario_app_role_app", joinColumns = @JoinColumn(name = "usuario_app_id"), inverseJoinColumns = @JoinColumn(name = "role_app_id"))
    private List<RoleApp> role;
}
