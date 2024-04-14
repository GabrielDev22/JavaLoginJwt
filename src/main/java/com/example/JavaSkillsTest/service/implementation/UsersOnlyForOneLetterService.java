package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.User;
import com.example.JavaSkillsTest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsersOnlyForOneLetterService {

    @Autowired
    UserRepository userRepository;

    public List<User> findUsersWithLetterL(){
        List<User> users = userRepository.findByNameContainingIgnoreCase("e");
        List<User> userResponse = users.stream()
                        .map(user -> new User(user.getId(), user.getPostId(), user.getName(), user.getEmail(), user.getBody()))
                        .collect(Collectors.toList());
        return userResponse;
    }
    public List<User> searchUsersWhoStartByLetter(){
        return userRepository.findByNameStartingWithIgnoreCase("n");
    }

    public List<User> buscarNombresComenzandoConLN(){
        List<User> resultados = userRepository.findByNameStartingWith("l");
        resultados.addAll(userRepository.findByNameStartingWith("n"));
        return resultados;
    }

    public List<User> filtrarNombresBaseDeDatos(){
        List<User> allUser = userRepository.findAll();
        return allUser.stream()
                .filter(user -> user.getName().toLowerCase().startsWith("a") || user.getName().toLowerCase().startsWith("b"))
                .collect(Collectors.toList());
    }

    public List<User> listadoDeCincuentaACien(){
        List<User> listParamUser = userRepository.findAll();
        List<User> usersInRange = new ArrayList<>();

        for (User user : listParamUser){
            if(user.getId() >= 50 && user.getId() <= 100){
                usersInRange.add(user);
            }
        }
        return usersInRange;
    }

}
