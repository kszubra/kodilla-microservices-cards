package com.kodilla.microservices.cards.api.enumeration;

import lombok.Getter;

public enum CardType {
    DEBIT(false),
    CREDIT(true);

    @Getter
    private final boolean allowsCreditedPurchase;

    CardType(boolean allowsCreditedPurchase) {
        this.allowsCreditedPurchase = allowsCreditedPurchase;
    }

}
