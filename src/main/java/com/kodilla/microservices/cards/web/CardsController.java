package com.kodilla.microservices.cards.web;

import com.kodilla.microservices.cards.api.request.CardCreateRequest;
import com.kodilla.microservices.cards.api.response.CustomerCardsResponse;
import com.kodilla.microservices.cards.service.interfaces.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/v1/cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardService cardService;

    @PostMapping
    public Long createCard(@RequestBody @Valid CardCreateRequest request) {
        return cardService.createCard(request);
    }

    @GetMapping
    public CustomerCardsResponse getCustomerCards(@RequestParam Long customerId) {
        return cardService.getCustomerCards(customerId);
    }

}
