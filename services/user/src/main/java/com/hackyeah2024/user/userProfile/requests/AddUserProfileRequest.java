package com.hackyeah2024.user.userProfile.requests;

public record AddUserProfileRequest (
        String keycloakId,
        String name,
        String lastname,
        String publicEmail,
        String phoneNumber,
        String jobTitle,
        String motivations,
        String bio,
        String location,
        Boolean isVolunteer
) {}
