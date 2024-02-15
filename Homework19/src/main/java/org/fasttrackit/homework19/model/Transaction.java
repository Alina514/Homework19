package org.fasttrackit.homework19.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@With
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Transaction{
    @Id
    @GeneratedValue
    private Long id;
    @Column
    private String product;
    @Column
    private TransactionType type;
    @Column
    private Double amount;
}
