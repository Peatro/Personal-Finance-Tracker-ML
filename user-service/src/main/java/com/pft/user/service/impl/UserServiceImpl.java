package com.pft.user.service.impl;

import com.pft.user.dto.response.UserDto;
import com.pft.user.exception.AlreadyExistsException;
import com.pft.user.exception.NotFoundException;
import com.pft.user.model.User;
import com.pft.user.repository.UserRepository;
import com.pft.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(UserDto::fromEntity)
                .toList();
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        existsByUsername(userDto);
        existsByEmail(userDto);

        User user = userDto.toEntity();

        return UserDto.fromEntity(userRepository.save(user));
    }

    @Override
    public UserDto getUserById(UUID userId) {
        return UserDto.fromEntity(
                userRepository.findById(userId)
                        .orElseThrow(NotFoundException::new)
        );
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.deleteById(userId);
    }

    private void existsByUsername(UserDto userDto) {
        if (userRepository.existsByUsername(userDto.userName())) {
            throw new AlreadyExistsException();
        }
    }

    private void existsByEmail(UserDto userDto) {
        if (userRepository.existsByEmail(userDto.userEmail())) {
            throw new AlreadyExistsException();
        }
    }
}
