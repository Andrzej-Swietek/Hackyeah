package com.hackyeah2024.feed.project;

import java.time.LocalDateTime;

public record VolunteerDTO(
        Long id,
        String userId,
        String location,
        String status, // e.g., "Pending", "Accepted"
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
