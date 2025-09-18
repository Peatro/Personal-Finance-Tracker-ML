package com.pft.user.dto.response;

import com.pft.user.model.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;

import java.util.UUID;

@Builder
public record UserDto(

        UUID userId,

        @NotBlank(message = "Username cannot be empty")
        @Size(min = 3, max = 20)
        String userName,

        @Email(message = "Email should be valid")
        String userEmail
) {
    public static UserDto fromEntity(User user) {
        return UserDto.builder()
                .userId(user.getId())
                .userName(user.getUsername())
                .userEmail(user.getEmail())
                .build();
    }

    public User toEntity() {
        return User.builder()
                .id(userId)
                .username(userName)
                .email(userEmail)
                .build();
    }

}
