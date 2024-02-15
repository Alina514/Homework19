package org.fasttrackit.homework19.repository;

import org.fasttrackit.homework19.model.Transaction;
import org.fasttrackit.homework19.model.TransactionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllById(Long id);
    List<Transaction> findAllByType(TransactionType type);

    List<Transaction> findAllByProduct(String product);

    List<Transaction> findAllByAmountBetween(Double maxAmount, Double minAmount);


}

