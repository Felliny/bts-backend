package net.feliny.bts_backend.controller;


import lombok.AllArgsConstructor;
import net.feliny.bts_backend.dto.LoginDto;
import net.feliny.bts_backend.dto.UserDto;
import net.feliny.bts_backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;

    // Create user REST API
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
        UserDto savedUser = userService.createUser(userDto);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    // Get user REST API
    @GetMapping("{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long userId){
        UserDto user = userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    // Login user REST API
    @PostMapping("/login")
    public ResponseEntity<UserDto> loginUser(@RequestBody LoginDto loginDto){
        UserDto user = userService.loginUser(loginDto.getEmail(), loginDto.getPassword());
        return ResponseEntity.ok(user);
    }
}
