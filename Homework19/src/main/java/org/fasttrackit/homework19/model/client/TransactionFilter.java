package org.fasttrackit.homework19.model.client;

import lombok.Builder;
import org.fasttrackit.homework19.model.TransactionType;

@Builder
public record TransactionFilter(
        String product,
        TransactionType type,
        Double minAmount,
        Double maxAmount
) {
}
