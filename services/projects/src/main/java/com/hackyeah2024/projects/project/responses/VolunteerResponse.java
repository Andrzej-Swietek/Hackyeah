package com.hackyeah2024.projects.project.responses;

import java.time.LocalDateTime;

public record VolunteerResponse(
        Long id,
        String userId,
        String location,
        String status, // e.g., "Pending", "Accepted"
        LocalDateTime startDate,
        LocalDateTime endDate
) {
}
