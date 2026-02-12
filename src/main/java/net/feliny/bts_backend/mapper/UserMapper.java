package net.feliny.bts_backend.mapper;

import net.feliny.bts_backend.dto.AccountDto;
import net.feliny.bts_backend.dto.UserDto;
import net.feliny.bts_backend.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {


    public static UserDto mapToUserDto(User user){

        List<AccountDto> accountDtos = new ArrayList<>();

        if (user.getAccounts() != null) {
            accountDtos = user.getAccounts().stream()
                    .map(account -> new AccountDto(
                            account.getId(),
                            account.getNumber(),
                            account.getAgency(),
                            account.getBalance(),
                            account.isActive()
                    ))
                    .toList();
        }

        return new UserDto(
                user.getId(),
                user.getName(),
                user.getCpf(),
                user.getEmail(),
                null,
                accountDtos
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
