package net.feliny.bts_backend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_accounts")
public class Account {

    //todo add sprint boot validation Account

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number", nullable = false, unique = true)
    private String number;

    @Column(name = "agency", nullable = false)
    private String agency = "0001";

    @Column(name = "balance", nullable = false, precision = 13, scale = 2)
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "active", nullable = false)
    private boolean active = true;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;
}



