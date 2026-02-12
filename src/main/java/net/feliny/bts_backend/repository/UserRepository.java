package net.feliny.bts_backend.repository;

import net.feliny.bts_backend.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // Spring understands that it should do: SELECT * FROM tb_users WHERE cpf = ?
    Optional<User> findByCpf(String cpf);

    // Spring understands that it should do: SELECT * FROM tb_users WHERE email = ?
    Optional<User> findByEmail(String email);

}
