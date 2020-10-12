package com.kodilla.microservices.cards.service;

import com.kodilla.microservices.cards.api.request.CardCreateRequest;
import com.kodilla.microservices.cards.api.snapshot.CardSnapshot;
import com.kodilla.microservices.cards.domain.model.Card;
import com.kodilla.microservices.cards.service.interfaces.CardCvvGenerator;
import com.kodilla.microservices.cards.service.interfaces.CardNumberGenerator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@AllArgsConstructor
public class CardMapper {

    private final CardNumberGenerator numberGenerator;
    private final CardCvvGenerator cvvGenerator;

    public Card mapToCard(CardCreateRequest request, Long customerId) {
        return Card.builder()
                .account(request.getAccountId())
                .customerId(customerId)
                .cardNumber(numberGenerator.generateCardNumber())
                .cardProvider(request.getCardProvider())
                .cardType(request.getCardType())
                .cvvNumber(cvvGenerator.generateCvvNumber())
                .expirationDate(LocalDate.now().plusYears(3L))
                .isActive(false)
                .build();
    }

    public CardSnapshot mapToSnapshot(Card card) {
        return CardSnapshot.builder()
                .account(card.getAccount())
                .cardId(card.getCardId())
                .cardNumber(card.getCardNumber())
                .cardProvider(card.getCardProvider())
                .cardType(card.getCardType())
                .cvvNumber(card.getCvvNumber())
                .expirationDate(card.getExpirationDate())
                .isActive(card.getIsActive())
                .build();
    }
}
