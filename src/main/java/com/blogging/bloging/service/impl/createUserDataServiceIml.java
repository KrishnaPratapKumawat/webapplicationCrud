package com.blogging.bloging.service.impl;

import com.blogging.bloging.model.UserData;
import com.blogging.bloging.repo.UserInfoRepo;
import com.blogging.bloging.service.CreateUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class createUserDataServiceIml implements CreateUserData {

    @Autowired
    private UserInfoRepo userInfoRepo;

    @Override
    public UserData createNewUser(UserData userData) {
        Date dateFormat = new Date();
        LocalDate localDate = LocalDate.now();
        userData.setCreatedDate(localDate);
        userData.setDelete(false);
        return this.userInfoRepo.save(userData);
    }

    @Override
    public List<UserData> getUsers() {
        List<UserData> userInfoRepoAll = this.userInfoRepo.findAll();
        return userInfoRepoAll.stream()
                .filter(userData -> !userData.isDelete()) // Assuming isDelete() is a method in UserData
                .collect(Collectors.toList());
    }

    @Override
    public UserData updateExistingUser(UserData userData1, Long userId){
        UserData userData = this.userInfoRepo.findById(userId).orElseThrow(()-> new RuntimeException(" User Id not found"));
       if (userData1.getName()==null){
           userData.setName(userData.getName());
       }else {
           userData.setName(userData1.getName());
       }
       if (userData1.getEmail()==null){
           userData.setEmail(userData.getEmail());
       }else {
           userData.setEmail(userData1.getEmail());
       }
       if (userData1.getPassword() ==null && userData1.getConfirmPassword() == null){
           userData.setPassword(userData.getPassword());
           userData.setConfirmPassword(userData.getConfirmPassword());
       }else {
           userData.setPassword(userData1.getPassword());
           userData.setConfirmPassword(userData1.getConfirmPassword());
       }
        if (userData1.getPhNum() ==null){
            userData.setPhNum(userData.getPhNum());
        }else {
            userData.setPhNum(userData1.getPhNum());
        }
        if (userData1.getUserName() == null) {
            userData.setUserName(userData.getUserName());
        }else {
            userData.setUserName(userData1.getUserName());
        }
        return this.userInfoRepo.save(userData);
    }
    @Override
    public UserData getUserById(Long userId) {
        UserData data = this.userInfoRepo.findById(userId).orElseThrow();
        if (!data.isDelete()) {
            return data;
        }else {
            return null;
        }
    }

    @Override
    public void deleteUserData(Long userId) {
        UserData data = this.userInfoRepo.findById(userId).orElseThrow();
       if (!data.delete){
           data.setDelete(true);
       }else {
           data.setDelete(false);
       }
       this.userInfoRepo.save(data);
    }

}
