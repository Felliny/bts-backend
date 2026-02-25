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
import java.util.stream.Collectors;

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
    public UserDto loginUser(String email, String password) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("invalid email or password"));

        if (!user.getPassword().equals(password)){
            throw new ResourceNotFoundException("invalid email or password");
        }


        return UserMapper.mapToUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();

        return users.stream().map(user -> UserMapper.mapToUserDto(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        if (updatedUser.getName() != null){
            user.setName(updatedUser.getName());
        }
        if (updatedUser.getEmail() != null){

            Optional<User> existingEmail = userRepository.findByEmail(updatedUser.getEmail());
            if (existingEmail.isPresent()){
                throw new ResourceAlreadyExistsException("This email address is already in use");
            }
            user.setEmail(updatedUser.getEmail());
        }
        if (updatedUser.getPassword() != null){
            user.setPassword(updatedUser.getPassword());
        }


        User updatedUserObj = userRepository.save(user);

        return UserMapper.mapToUserDto(updatedUserObj);
    }
}
