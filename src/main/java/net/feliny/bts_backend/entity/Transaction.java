package net.feliny.bts_backend.entity;
import net.feliny.bts_backend.enums.TransactionType;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_transactions")
public class Transaction {

    //todo add sprint boot validation Transaction

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount", nullable = false, precision = 13, scale = 2)
    private BigDecimal amount= BigDecimal.ZERO;

    @JoinColumn(name = "payer_id")
    @ManyToOne
    private Account payer;

    @JoinColumn(name = "payee_id")
    @ManyToOne
    private Account payee;

    @Column(name = "description", length = 150)
    private String description;

    @Column(name = "created_at", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime timestamp;

    @Enumerated(EnumType.STRING)
    @Column(name = "type",nullable = false)
    private TransactionType type;
}
