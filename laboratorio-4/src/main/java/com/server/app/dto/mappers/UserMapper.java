package com.server.app.dto.mappers;

import com.server.app.dto.response.UserResponse;
import com.server.app.dto.user.UserCreateDto;
import com.server.app.dto.user.UserUpdateDto;
import com.server.app.entities.Role;
import com.server.app.entities.User;

public class UserMapper {
    public static User toCreateEntity(UserCreateDto createDto, Role role) {
        return User.builder()
                .username(createDto.getUsername())
                .name(createDto.getName())
                .surname(createDto.getSurname())
                .email(createDto.getEmail())
                .password(createDto.getPassword())
                .role(role)
                .build();
    }

    public static User toUpdateEntity(UserUpdateDto updateDto, Role role) {
        return User.builder()
                .username(updateDto.getUsername())
                .name(updateDto.getName())
                .surname(updateDto.getSurname())
                .email(updateDto.getEmail())
                .role(role)
                .build();
    }

    public static UserResponse toDto(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .surname(user.getSurname())
                .email(user.getEmail())
                .role(user.getRole())
                .build();
    }

}
