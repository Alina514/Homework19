package org.fasttrackit.homework19.service;

import lombok.RequiredArgsConstructor;
import org.fasttrackit.homework19.model.Transaction;
import org.fasttrackit.homework19.repository.TransactionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.List;
import java.util.Random;

import static org.fasttrackit.homework19.model.TransactionType.BUY;
import static org.fasttrackit.homework19.model.TransactionType.SELL;

@Component
@RequiredArgsConstructor
public class CommandRunner implements CommandLineRunner {
    private final TransactionRepository repository;
    private final TransactionService service;

    @Override
    public void run(String... args) {
        Random random = new Random();
        repository.saveAll(List.of(
                Transaction.builder()
                        .id(random.nextLong())
                        .product("TV")
                        .type(BUY)
                        .amount(3000D)
                        .build(),
                Transaction.builder()
                        .id(random.nextLong())
                        .product("laptop")
                        .type(SELL)
                        .amount(8000D)
                        .build(),
                Transaction.builder()
                        .id(random.nextLong())
                        .product("Phone")
                        .type(BUY)
                        .amount(1500D)
                        .build()
                )
        );
    }
}

