package org.fasttrackit.homework19.service;
import org.fasttrackit.homework19.model.TransactionType;

import org.fasttrackit.homework19.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.fasttrackit.homework19.model.Transaction;

import java.util.*;

    @Service
    public class TransactionService {
        private final TransactionRepository repository;

        public TransactionService(TransactionRepository repository) {
            this.repository = repository;
        }

        public List<Transaction> getAllTransactions() {
            return repository.findAll();
        }
        public List<Transaction> getAllTransactionsByProduct(String product) {
            return repository.findAllByProduct(product);
        }
        public List<Transaction> getAllTransactionsByType(TransactionType type) {
            return repository.findAllByType(type);
        }
        public Transaction getAllTransactionById(Long id) {
            return repository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Transaction with id:%s was not found".formatted(id)));
        }
        public List<Transaction> getAllTransactionsByAmount(Double minAmount, Double maxAmount) {
            return repository.findAllByAmountBetween(maxAmount, minAmount);

        }
        public Transaction deleteById(Long id) {
            Transaction foundTransaction = getAllTransactionById(id);
            repository.deleteById(id);
            return foundTransaction;
        }
        public Transaction addNewTransaction (Transaction newTransaction) {
            return repository.save(newTransaction);
        }
        public Transaction replaceTransaction(Long id, Transaction replaceTransaction) {
           Transaction foundTransaction = getAllTransactionById(id);
            Transaction updatedTransaction = Transaction.builder()
                    .id(foundTransaction.getId())
                    .product(replaceTransaction.getProduct())
                    .type(replaceTransaction.getType())
                    .amount(replaceTransaction.getAmount())
                    .build();
            return repository.save(updatedTransaction);
        }
    }
