package com.pft.user.service;

import com.pft.user.dto.response.UserDto;

import java.util.List;
import java.util.UUID;

public interface UserService {


    List<UserDto> getAllUsers();


    UserDto createUser(UserDto user);


    UserDto getUserById(UUID userId);


    void deleteUser(UUID userId);
}
