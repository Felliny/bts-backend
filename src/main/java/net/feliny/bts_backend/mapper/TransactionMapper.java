package net.feliny.bts_backend.mapper;

import net.feliny.bts_backend.dto.AccountDto;
import net.feliny.bts_backend.dto.TransactionDto;
import net.feliny.bts_backend.entity.Transaction;

public class TransactionMapper {

    public static TransactionDto mapToTransactionDto(Transaction transaction){

        // Reuses AccountMapper!
        // if transaction.getPayer() is null (Deposit), variable is null.
        AccountDto payerDto = (transaction.getPayer() != null)
                ? AccountMapper.mapToAccountDto(transaction.getPayer())
                : null;

        AccountDto payeeDto = (transaction.getPayee() != null)
                ? AccountMapper.mapToAccountDto(transaction.getPayee())
                : null;


        return new TransactionDto(
                transaction.getId(),
                transaction.getAmount(),
                payerDto,
                payeeDto,
                transaction.getDescription(),
                transaction.getTimestamp(),
                transaction.getType()
        );
    }

    public static Transaction mapToTransaction(TransactionDto transactionDto){
        return new Transaction(
                transactionDto.getId(),
                transactionDto.getAmount(),
                null,
                null,
                transactionDto.getDescription(),
                transactionDto.getTimestamp(),
                transactionDto.getType()
        );
    }
}
