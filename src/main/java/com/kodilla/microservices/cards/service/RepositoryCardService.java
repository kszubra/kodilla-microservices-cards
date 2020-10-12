package com.kodilla.microservices.cards.service;

import com.kodilla.microservices.cards.api.request.CardCreateRequest;
import com.kodilla.microservices.cards.api.response.AccountExistsResponse;
import com.kodilla.microservices.cards.api.response.CustomerCardsResponse;
import com.kodilla.microservices.cards.domain.model.Card;
import com.kodilla.microservices.cards.domain.repository.CardRepository;
import com.kodilla.microservices.cards.service.interfaces.AccountsProvider;
import com.kodilla.microservices.cards.service.interfaces.CardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RepositoryCardService implements CardService {

    private final CardMapper mapper;
    private final CardRepository repository;
    private final AccountsProvider accountsProvider;

    @Override
    @Transactional
    public Long createCard(CardCreateRequest request) {
        log.info("Creating new card for account: {}", request.getAccountId());
        AccountExistsResponse account = accountsProvider.getAccountExists(request.getAccountId());

        if(Objects.nonNull(account.getExists()) && account.getExists() && Objects.nonNull(account.getCustomerId())) {
            Card card = mapper.mapToCard(request, account.getCustomerId());
            return repository.save(card).getCardId();
        } else {
            //TODO: system of passing errors
            return -1L;
        }
    }

    @Override
    public CustomerCardsResponse getCustomerCards(Long customerId) {
        log.info("Getting cards of a customer: {}", customerId);
        return new CustomerCardsResponse(
                repository.findAllByCustomerId(customerId).stream().map(mapper::mapToSnapshot).collect(Collectors.toList())
        );
    }
}
