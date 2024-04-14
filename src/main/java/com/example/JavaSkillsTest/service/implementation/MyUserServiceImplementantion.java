package com.example.JavaSkillsTest.service.implementation;

import com.example.JavaSkillsTest.module.MyUsers;
import com.example.JavaSkillsTest.repository.MyUserRepository;
import com.example.JavaSkillsTest.service.MyUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class MyUserServiceImplementantion implements MyUserService {

    private final MyUserRepository myUserRepository;

    @Override
    public List<MyUsers> getAllMyUser() {
        List<MyUsers> getAllMyUser = null;
        try{
            getAllMyUser = myUserRepository.findAll();
            if(getAllMyUser.isEmpty()){
                return null;
            }
            return getAllMyUser;
        }catch (Exception e){
            e.printStackTrace();
        }
        return getAllMyUser;
    }

    @Override
    public List<MyUsers> getMyUserRangeValores() {
        List<MyUsers> getMyUserRange = new ArrayList<>();
        try{
            List<MyUsers> postMyUserRange = myUserRepository.findAll();
            for (MyUsers myUsers : postMyUserRange){
                if(myUsers.getId() > 3 && myUsers.getId() < 8 || myUsers.getName() == null && myUsers.getUsername().toLowerCase().startsWith("k")){
                    getMyUserRange.add(myUsers);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getMyUserRange;
    }

    @Override
    public List<MyUsers> getMyUserFilterForLetter() {
        List<MyUsers> getMyUserForLetter = new ArrayList<>();
        try{
            List<MyUsers> postMyUserForLetter = myUserRepository.findAll();
            for (MyUsers myUsers : postMyUserForLetter){
                if(myUsers.getUsername().toLowerCase().startsWith("b") || myUsers.getUsername().toLowerCase().startsWith("s")){
                    getMyUserForLetter.add(myUsers);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getMyUserForLetter;
    }

    @Override
    public List<MyUsers> getMyUserFilterFullBody() {
        List<MyUsers> getMyUserFilterFullBody = new ArrayList<>();
        try{
            List<MyUsers> postMyUserFullBody = myUserRepository.findAll();
            for (MyUsers myUsers : postMyUserFullBody){
                if(myUsers.getWebsite() == null && myUsers.getWebsite().endsWith("net") || myUsers.getPhone().endsWith("9") || myUsers.getCompany().getCatchPhrase().length() > 20){
                    getMyUserFilterFullBody.add(myUsers);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getMyUserFilterFullBody;
    }

    @Override
    public MyUsers getByIdMyUser(Integer id) {
        MyUsers getByIdMyUser = null;
        try{
            getByIdMyUser = myUserRepository.getReferenceById(id);
            if(getByIdMyUser.getId() == null){
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return getByIdMyUser;
    }

    @Override
    public List<MyUsers> createMyUserAll(List<MyUsers> myUsers) {
        List<MyUsers> createMyUserAll = new ArrayList<>();
        try{
            for(MyUsers myUser : myUsers){
                MyUsers createMyUsers = myUserRepository.save(myUser);
                createMyUserAll.add(createMyUsers);
            }
            return createMyUserAll;
        }catch (Exception e){
            e.printStackTrace();
        }
        return createMyUserAll;
    }

    @Override
    public MyUsers createMyUser(MyUsers myUsers) {
        MyUsers createMyUser = null;
        try{
            createMyUser = myUserRepository.save(myUsers);
            if(!StringUtils.hasText(myUsers.getName())){
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return createMyUser;
    }

    @Override
    public MyUsers updateMyUser(MyUsers myUsers) {
        MyUsers updateMyUser = null;
        try{
            updateMyUser = myUserRepository.save(myUsers);
            if(!StringUtils.hasText(updateMyUser.getName())){
                return null;
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return updateMyUser;
    }

    @Override
    public void deleteMyUserAll() {
        myUserRepository.deleteAll();
    }

    @Override
    public void deleteByIdMyUser(Integer id) {
        myUserRepository.deleteById(id);
    }
}
