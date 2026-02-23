package net.feliny.bts_backend.service;

import net.feliny.bts_backend.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
}
