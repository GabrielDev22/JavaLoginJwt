package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.User;
import com.example.JavaSkillsTest.repository.UserRepository;
import com.example.JavaSkillsTest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserServiceImplementation implements UserService {
    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUser() {
        List<User> allUser = null;
        try {
            allUser = userRepository.findAll();
            if (allUser.isEmpty()) {
                return null;
            }
            return allUser;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allUser;
    }

    @Override
    public User getUserById(Integer id){
        User getUsuerById = null;
        try{
            getUsuerById = userRepository.getReferenceById(id);
            if(getUsuerById.getId() == null){
                return null;
            }
            return getUsuerById;
        }catch (Exception e){
            e.printStackTrace();
        }
        return getUsuerById;
    }

    @Override
    public List<User> createUser(List<User> user){
       List<User> createUsuarios = new ArrayList<>();
        for(User users : user){
            User createUsuario = userRepository.save(users);
            createUsuarios.add(createUsuario);
        }
        return createUsuarios;
    }

    @Override
    public User updateUser(User user) {
        User updateUser = null;
        try{
            updateUser = userRepository.save(user);
            if(!StringUtils.hasText(user.getName()) &&
                    !StringUtils.hasText(user.getEmail()) &&
                    !StringUtils.hasText(user.getBody()));{
                return updateUser;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return updateUser;
    }

    @Override
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUserAll() {
        userRepository.deleteAll();
    }


}
