package com.hackyeah2024.projects.project.requests;

import java.time.LocalDateTime;
import java.util.Set;

public record ProjectRequest(
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
        Set<StageRequest> stages) {
}

