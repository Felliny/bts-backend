package net.feliny.bts_backend.service;

import net.feliny.bts_backend.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    TransactionDto createTransaction(TransactionDto transactionDto);

    TransactionDto getTransactionById(Long transactionId);

    List<TransactionDto> getAllTransactionsByAccount(Long accountId);
}
