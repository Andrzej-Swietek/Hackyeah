package com.hackyeah2024.feed.company;

import java.util.List;

public record NgoDTO(
        Long id,
        String name,
        String strategyDescription,
        String socialGoals,
        String teamDescription,
        String ownerId,
        List<ContactDTO> contacts,
        AddressDTO address
) {}
