package com.hackyeah2024.user.userProfile.responses;

public record UserProfileResponse(
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
        Integer upVotes
) {
}
