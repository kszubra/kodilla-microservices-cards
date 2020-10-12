package com.kodilla.microservices.cards.service.interfaces;

import com.kodilla.microservices.cards.api.response.AccountExistsResponse;

public interface AccountsProvider {
    public AccountExistsResponse getAccountExists(Long accountId);
}
