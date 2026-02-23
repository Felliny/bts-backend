/*
Name: Luan Camilo Nogueira
Date: 23/02/2026
Function:
 */


package net.feliny.bts_backend.service.impl;

import lombok.AllArgsConstructor;
import net.feliny.bts_backend.dto.AccountDto;
import net.feliny.bts_backend.entity.Account;
import net.feliny.bts_backend.entity.User;
import net.feliny.bts_backend.mapper.AccountMapper;
import net.feliny.bts_backend.repository.AccountRepository;
import net.feliny.bts_backend.repository.UserRepository;
import net.feliny.bts_backend.service.AccountService;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private UserRepository userRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        User user = userRepository.findById(accountDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found with id: " + accountDto.getUserId()));

        Account account = AccountMapper.mapToAccount(accountDto);

        account.setUser(user);

        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }
}
