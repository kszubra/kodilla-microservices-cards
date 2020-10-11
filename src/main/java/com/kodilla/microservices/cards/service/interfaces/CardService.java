package com.kodilla.microservices.cards.service.interfaces;

import com.kodilla.microservices.cards.api.request.CardCreateRequest;
import com.kodilla.microservices.cards.api.response.CustomerCardsResponse;

public interface CardService {

    Long createCard(CardCreateRequest request);

    CustomerCardsResponse getCustomerCards(Long customerId);
}
