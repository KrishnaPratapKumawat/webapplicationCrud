package com.blogging.bloging.service;

import com.blogging.bloging.model.UserData;
import org.springframework.http.ResponseEntity;

import java.io.IOException;
import java.util.List;

public interface CreateUserData {
    UserData createNewUser(UserData userData);
    List<UserData>getUsers();
    UserData updateExistingUser(UserData userData, Long UserId);
    UserData getUserById(Long userId);
    void deleteUserData(Long userId);
}
