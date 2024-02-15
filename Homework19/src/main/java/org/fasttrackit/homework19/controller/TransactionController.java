package org.fasttrackit.homework19.controller;
import lombok.RequiredArgsConstructor;
import org.fasttrackit.homework19.model.Transaction;
import org.fasttrackit.homework19.model.TransactionType;
import org.fasttrackit.homework19.service.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("transactions")
public class TransactionController {
    private final TransactionService service;

    @GetMapping
    public List<Transaction> getAllTransaction(String product, TransactionType type) {
        if (product != null) {
            return service.getAllTransactionsByProduct(product);
        }
        if (type != null) {
            return service.getAllTransactionsByType(type);
        }
        return service.getAllTransactions();
    }
    @GetMapping("{id}")
    public Transaction getOneTransaction(@PathVariable Long id) {
        return service.getAllTransactionById(id);
    }
    @DeleteMapping("{id}")
    public Transaction deleteById(@PathVariable Long id) {
        return service.deleteById(id);
    }
    @PostMapping
    public Transaction addTransaction(@RequestBody Transaction newTransaction){
        return service.addNewTransaction(newTransaction);
    }
    @PutMapping("{id}")
    public Transaction replaceTransaction(@PathVariable Long id, @RequestBody Transaction replaceTransaction) {
        return service.replaceTransaction(id, replaceTransaction);
    }
}
