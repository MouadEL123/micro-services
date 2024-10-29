package net.elazzioui.accountservice.entities;

import jakarta.persistence.*;
import lombok.*;
import net.elazzioui.accountservice.enums.AccountType;
import net.elazzioui.accountservice.models.Customer;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class Account {
    @Id
    private String id;
    private double balance;
    private LocalDate createdAt;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private Long customerId;
    @Transient
    private Customer customer;
}
