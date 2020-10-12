package com.kodilla.microservices.cards.service;

import com.kodilla.microservices.cards.api.response.AccountExistsResponse;
import com.kodilla.microservices.cards.connector.AccountsConnector;
import com.kodilla.microservices.cards.service.interfaces.AccountsProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SimpleAccountsProvider implements AccountsProvider {

    private final AccountsConnector connector;

    @Override
    public AccountExistsResponse getAccountExists(Long accountId) {
        return connector.getAccountExists(accountId);
    }
}
