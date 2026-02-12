package net.feliny.bts_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.feliny.bts_backend.enums.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private Long id;
    private BigDecimal amount;
    private AccountDto payer;
    private AccountDto payee;
    private String description;
    private LocalDateTime timestamp;
    private TransactionType type;
}
