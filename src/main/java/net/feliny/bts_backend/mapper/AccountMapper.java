package net.feliny.bts_backend.mapper;

import net.feliny.bts_backend.dto.AccountDto;
import net.feliny.bts_backend.entity.Account;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Account account){
        return new AccountDto(
                account.getId(),
                account.getNumber(),
                account.getAgency(),
                account.getBalance(),
                account.isActive(),
                account.getUser().getId()
        );
    }

    public static Account mapToAccount(AccountDto accountDto){
        return new Account(
                accountDto.getId(),
                accountDto.getNumber(),
                accountDto.getAgency(),
                accountDto.getBalance(),
                accountDto.isActive(),
                null
        );
    }
}
