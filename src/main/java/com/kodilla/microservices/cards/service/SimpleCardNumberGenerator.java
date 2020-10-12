package com.kodilla.microservices.cards.service;

import com.kodilla.microservices.cards.service.interfaces.CardNumberGenerator;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimpleCardNumberGenerator implements CardNumberGenerator {

    @Override
    public String generateCardNumber() {
        return UUID.randomUUID().toString();
    }
}
