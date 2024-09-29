package com.hackyeah2024.feed.project;

import java.time.LocalDateTime;
import java.util.List;

public record ProjectDTO(
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
        List<VolunteerDTO> volunteers,
        String category,
        List<StageDTO> stages,
        StageDTO currentStage,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate
) {
}
