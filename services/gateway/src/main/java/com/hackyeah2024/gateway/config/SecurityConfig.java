package com.hackyeah2024.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity server) {
        server.csrf(ServerHttpSecurity.CsrfSpec::disable)
                .authorizeExchange(exchange ->
                        exchange
                                .pathMatchers("/eureka/**").permitAll()
                                .pathMatchers("/actuator/**").permitAll()
                                .pathMatchers("/api/v1/company/**").permitAll()
                                .pathMatchers("/api/v1/feed/**").permitAll()
                                .pathMatchers("/api/v1/user-profiles/**").permitAll()
                                .pathMatchers("/api/v1/project/**").permitAll()
                                .anyExchange().authenticated()
                ).oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()));

        return server.build();
    }
}