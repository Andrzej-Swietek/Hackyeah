package com.hackyeah2024.feed.user;

import java.util.Set;

public record UserResponse(
        Long id,
        String keycloakId,
        String name,
        String lastname,
        String publicEmail,
        String phoneNumber,
        String jobTitle,
        String motivations,
        String bio,
        String location,
        Boolean isVolunteer,
        Integer upVotes,
        Set<PastExperienceResponse> pastExperiences
) {
}
