package net.feliny.bts_backend.service.impl;

import lombok.AllArgsConstructor;
import net.feliny.bts_backend.dto.AccountDto;
import net.feliny.bts_backend.entity.Account;
import net.feliny.bts_backend.entity.User;
import net.feliny.bts_backend.exception.ResourceNotFoundException;
import net.feliny.bts_backend.mapper.AccountMapper;
import net.feliny.bts_backend.repository.AccountRepository;
import net.feliny.bts_backend.repository.UserRepository;
import net.feliny.bts_backend.service.AccountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;
    private UserRepository userRepository;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {

        User user = userRepository.findById(accountDto.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("[CREATE] User not found with id: " + accountDto.getUserId()));

        Account account = AccountMapper.mapToAccount(accountDto);

        account.setUser(user);

        Account savedAccount = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("[GET] User not found with id: " + accountId));


        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public List<AccountDto> getAllAccounts() {
        List<Account> accounts = accountRepository.findAll();

        return accounts.stream().map(account -> AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
    }

    @Override
    public AccountDto updateAccount(Long accountId, AccountDto updatedAccount) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("[UPDATE] User not found with id: " + accountId));

        if (updatedAccount.getBalance() != null){
            account.setBalance(updatedAccount.getBalance());
        }
        else {
            account.setActive(updatedAccount.getActive());
        }


        Account updatedAccountObj = accountRepository.save(account);

        return AccountMapper.mapToAccountDto(updatedAccountObj);
    }
}
