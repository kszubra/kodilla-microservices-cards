package com.kodilla.microservices.cards.domain.repository;

import com.kodilla.microservices.cards.domain.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardRepository extends JpaRepository<Card, Long> {
    List<Card> findAllByCustomerId(Long customerId);
}
