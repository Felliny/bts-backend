package net.feliny.bts_backend.service;

import net.feliny.bts_backend.dto.AccountDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(Long accountId);

    List<AccountDto> getAllAccounts();

    AccountDto updateAccount(Long accountId, AccountDto updatedAccount);
}
