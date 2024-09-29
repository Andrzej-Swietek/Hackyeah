package com.hackyeah2024.user.userProfile.responses;

import java.util.List;
import java.util.Set;

public record RichUserProfileResponse(
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
) {}

