package com.kodilla.microservices.cards.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.kodilla.microservices.cards.domain.repository")
@EntityScan(basePackages = {"com.kodilla.microservices.cards.domain.model"})
@ComponentScan(basePackages = {"com.kodilla.microservices.cards.service.*"})
public class CoreConfiguration {

}
