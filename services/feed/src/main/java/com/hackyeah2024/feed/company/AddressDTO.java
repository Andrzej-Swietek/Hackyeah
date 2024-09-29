package com.hackyeah2024.feed.company;

public record AddressDTO(
        Long id,
        String street,
        String buildingNumber,
        String city,
        String state,
        String country,
        String zip
) {}
