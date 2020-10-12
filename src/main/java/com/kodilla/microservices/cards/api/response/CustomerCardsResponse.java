package com.kodilla.microservices.cards.api.response;

import com.kodilla.microservices.cards.api.snapshot.CardSnapshot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CustomerCardsResponse {

    private List<CardSnapshot> cards;
}
