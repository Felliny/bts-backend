package net.feliny.bts_backend.service.impl;

import lombok.AllArgsConstructor;
import net.feliny.bts_backend.dto.UserDto;
import net.feliny.bts_backend.entity.User;
import net.feliny.bts_backend.mapper.UserMapper;
import net.feliny.bts_backend.repository.UserRepository;
import net.feliny.bts_backend.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        User user = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);


        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {
        return null;
    }

    @Override
    public List<UserDto> getAllUsers() {
        return List.of();
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        return null;
    }
}
