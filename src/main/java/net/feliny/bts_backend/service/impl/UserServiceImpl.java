package net.feliny.bts_backend.service.impl;

import lombok.AllArgsConstructor;
import net.feliny.bts_backend.dto.UserDto;
import net.feliny.bts_backend.entity.User;
import net.feliny.bts_backend.exception.ResourceAlreadyExistsException;
import net.feliny.bts_backend.exception.ResourceNotFoundException;
import net.feliny.bts_backend.mapper.UserMapper;
import net.feliny.bts_backend.repository.UserRepository;
import net.feliny.bts_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {

        Optional<User> existingEmail = userRepository.findByEmail(userDto.getEmail());
        if (existingEmail.isPresent()){
            throw new ResourceAlreadyExistsException("Email already registered");
        }

        Optional<User> existingCpf = userRepository.findByCpf(userDto.getCpf());
        if (existingCpf.isPresent()){
            throw new ResourceAlreadyExistsException("CPF already registered");
        }


        User user = UserMapper.mapToUser(userDto);

        User savedUser = userRepository.save(user);


        return UserMapper.mapToUserDto(savedUser);
    }

    @Override
    public UserDto getUserById(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));


        return UserMapper.mapToUserDto(user);
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
