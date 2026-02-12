package net.feliny.bts_backend.repository;

import net.feliny.bts_backend.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // Spring understands that it should do: SELECT * FROM tb_accounts WHERE number = ?
    Optional<Account> findByNumber(String number);

}
