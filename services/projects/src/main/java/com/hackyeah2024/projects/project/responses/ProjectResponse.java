package com.hackyeah2024.projects.project.responses;

import java.time.LocalDateTime;
import java.util.Set;

public record ProjectResponse(
        Long id,
        String name,
        String description,
        Long ngoID,
        Integer desiredBudget,
        String location,
        String status,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Integer estimatedVolunteers,
        Integer actualVolunteers,
        String category,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        Set<StageResponse> stages,
        StageResponse currentStage,
        Set<VolunteerResponse> volunteers
) {
}
