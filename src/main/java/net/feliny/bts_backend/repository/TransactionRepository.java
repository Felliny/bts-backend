package net.feliny.bts_backend.repository;

import net.feliny.bts_backend.entity.Account;
import net.feliny.bts_backend.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // 1. Search all transactions where the account was the PAYER (Outflows)
    List<Transaction> findByPayer(Account payer);

    // 2. Search all transactions where the account was the PAYEE (Inflows)
    List<Transaction> findByPayee(Account payee);
}
