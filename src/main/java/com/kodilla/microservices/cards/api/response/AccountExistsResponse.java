package com.kodilla.microservices.cards.api.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountExistsResponse {

    private Long accountId;

    private Long customerId;

    private Boolean exists;
}
