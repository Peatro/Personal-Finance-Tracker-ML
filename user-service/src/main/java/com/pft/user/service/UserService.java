package com.pft.user.service;

import com.pft.user.model.User;

import java.util.List;
import java.util.UUID;

public interface UserService {


    List<User> getAllUsers();


    User createUser(User user);


    User getUserById(UUID userId);


    void deleteUser(UUID userId);
}
