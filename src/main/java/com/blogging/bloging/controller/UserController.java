package com.blogging.bloging.controller;

import com.blogging.bloging.model.UserData;
import com.blogging.bloging.repo.UserInfoRepo;
import com.blogging.bloging.service.CreateUserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    CreateUserData userDataService;
    @Autowired
    UserInfoRepo userInfoRepo;

    @PostMapping("/createUser")
    public ResponseEntity<UserData> createNewUser(@RequestBody UserData userData){
        UserData response = this.userDataService.createNewUser(userData);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping("/getUsers")
    public ResponseEntity<List<UserData>> getUsers(){
        List<UserData> userDataList = this.userDataService.getUsers();
        return new ResponseEntity<>(userDataList, HttpStatus.OK);
    }
    @GetMapping("/getUserById/{userId}")
    public ResponseEntity<UserData> getUserById(@PathVariable Long userId){
        UserData userData = this.userDataService.getUserById(userId);
        return ResponseEntity.ok(userData);
    }
    @DeleteMapping("/DeleteUser/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId){
         this.userDataService.deleteUserData(userId);
        return ResponseEntity.ok("Your user was deleted");
    }
    @PutMapping("/updateUser/{userId}")
    public ResponseEntity<UserData>updateUser(@PathVariable Long userId,@RequestBody UserData userData){
        UserData data = this.userDataService.updateExistingUser(userData,userId);
        return ResponseEntity.ok(data);
    }

}
