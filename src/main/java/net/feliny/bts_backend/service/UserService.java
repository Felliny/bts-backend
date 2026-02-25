package net.feliny.bts_backend.service;

import net.feliny.bts_backend.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    UserDto loginUser(String email, String password);

    List<UserDto> getAllUsers();

    UserDto updateUser(Long userId, UserDto updatedUser);
}
