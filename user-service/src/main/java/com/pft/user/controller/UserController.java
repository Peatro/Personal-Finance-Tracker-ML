package com.pft.user.controller;

import com.pft.user.dto.response.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public interface UserController {

    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers();

    @PostMapping
    ResponseEntity<UserDto> createUser(
            @RequestBody UserDto userDto
    );

    @GetMapping("/{userId}")
    ResponseEntity<UserDto> getUser(
            @PathVariable UUID userId
    );

    @DeleteMapping("/{userId}")
    ResponseEntity<Void> deleteUser(
            @PathVariable UUID userId
    );
}
