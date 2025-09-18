package com.pft.user.service;

import com.pft.user.dto.response.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public interface UserService {


    List<UserDto> getAllUsers();


    UserDto createUser(UserDto user);


    UserDto getUserById(UUID userId);


    void deleteUser(UUID userId);
}
