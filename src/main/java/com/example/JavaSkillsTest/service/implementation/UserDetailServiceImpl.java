package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.model.*;
import com.example.JavaSkillsTest.repository.RoleRepository;
import com.example.JavaSkillsTest.repository.UserAppRepository;
import com.example.JavaSkillsTest.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.management.relation.Role;
import java.security.Permission;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserAppRepository userAppRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UsuarioApp usuarioApp = userAppRepository.findUserAppByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario " + username + "no existe"));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        List<RoleEnum> roleEnumList = usuarioApp.getRole().stream()
                .map(RoleApp::getRoleEnum)
                .collect(Collectors.toList());

        for (RoleEnum roleEnum : roleEnumList){
            authorityList.add(new SimpleGrantedAuthority("ROLE_" + roleEnum.name()));
        }

        return new User(usuarioApp.getUsername(),
                usuarioApp.getPassword(),
                usuarioApp.isEnabled(),
                usuarioApp.isAccountNoExpired(),
                usuarioApp.isCredentialNoExpired(),
                usuarioApp.isAccountNoLocked(),
                authorityList);
    }


    public AuthResponse loginUser(AuthLoginRequest authLoginRequest){
        String username = authLoginRequest.getUsername();
        String password = authLoginRequest.getPassword();

        Authentication authentication = this.authenticate(username, password);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String accessToken = jwtUtils.createToken(authentication);

        AuthResponse authResponse = new AuthResponse(username, "User loged succesfuly", accessToken, true);

        return authResponse;
    }

    public Authentication authenticate(String username, String password){
        UserDetails userDetails = this.loadUserByUsername(username);

        if(userDetails == null){
            throw new BadCredentialsException("Invalid username or password");
        }

        if(!passwordEncoder.matches(password, userDetails.getPassword())){
            throw new BadCredentialsException("Invalid password");
        }

        return new UsernamePasswordAuthenticationToken(username, userDetails.getPassword(), userDetails.getAuthorities());
    }

    public AuthResponse createUser(AuthCreateUserRequest authCreateUserRequest) throws IllegalAccessException{
        String username = authCreateUserRequest.getUsername();
        String password = authCreateUserRequest.getPassword();
        List<String> roleRequest = authCreateUserRequest.getRoleListName();
        List<RoleApp> roleAppSet = roleRepository.findRoleAppByRoleEnumIn(roleRequest).stream().collect(Collectors.toList());
        if(roleAppSet.isEmpty()){
            throw new IllegalAccessException("The Roles specified does no exist.");
        }
        UsuarioApp usuarioApp = UsuarioApp.builder()
                .username(username)
                .password(passwordEncoder.encode(password))
                .role(roleAppSet)
                .isEnabled(true)
                .accountNoLocked(true)
                .accountNoExpired(true)
                .credentialNoExpired(true)
                .build();
        UsuarioApp usuarioCreate = userAppRepository.save(usuarioApp);
        List<SimpleGrantedAuthority> authorities = roleAppSet.stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleEnum().name())).collect(Collectors.toList());
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = new UsernamePasswordAuthenticationToken(usuarioCreate.getUsername(), usuarioApp.getPassword(), authorities);
        String accessToken = jwtUtils.createToken(authentication);

        AuthResponse authResponse = new AuthResponse(usuarioCreate.getUsername(), "user Create succesfully", accessToken,  true);

        return authResponse;
    }

}
