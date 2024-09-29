package com.hackyeah2024.feed.company;

import lombok.Builder;

@Builder
public record ContactDTO(
        Long id,
        String contactName,
        String contactEmail,
        String contactPhone
) {}
