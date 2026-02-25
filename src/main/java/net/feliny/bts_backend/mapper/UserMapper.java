package net.feliny.bts_backend.mapper;

import net.feliny.bts_backend.dto.UserDto;
import net.feliny.bts_backend.entity.User;


public class UserMapper {


    public static UserDto mapToUserDto(User user){


        return new UserDto(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                null,
                null
        );
    }

    public static User mapToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getCpf(),
                userDto.getEmail(),
                userDto.getPassword(),
                null
        );
    }
}
