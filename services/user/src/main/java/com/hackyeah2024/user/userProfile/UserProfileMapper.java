package com.hackyeah2024.user.userProfile;

import com.hackyeah2024.user.userProfile.requests.AddUserProfileRequest;
import com.hackyeah2024.user.userProfile.responses.PastExperienceResponse;
import com.hackyeah2024.user.userProfile.responses.RichUserProfileResponse;
import com.hackyeah2024.user.userProfile.responses.UserProfileResponse;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserProfileMapper {
    public UserProfile toUserProfile(AddUserProfileRequest request) {
        if (request == null)
            return null;

        return UserProfile.builder()
                .keycloakId(request.keycloakId())
                .name(request.name())
                .lastname(request.lastname())
                .publicEmail(request.publicEmail())
                .phoneNumber(request.phoneNumber())
                .jobTitle(request.jobTitle())
                .motivations(request.motivations())
                .bio(request.bio())
                .location(request.location())
                .isVolunteer(request.isVolunteer())
                .upVotes(0)
                .build();
    }

    public UserProfileResponse toUserProfileResponse(UserProfile userProfile) {
        return new UserProfileResponse(
                userProfile.getId(),
                userProfile.getKeycloakId(),
                userProfile.getName(),
                userProfile.getLastname(),
                userProfile.getPublicEmail(),
                userProfile.getPhoneNumber(),
                userProfile.getJobTitle(),
                userProfile.getMotivations(),
                userProfile.getBio(),
                userProfile.getLocation(),
                userProfile.getIsVolunteer(),
                userProfile.getUpVotes()
        );
    }

    public RichUserProfileResponse toRichUserProfileResponse(UserProfile userProfile) {
        return new RichUserProfileResponse(
                userProfile.getId(),
                userProfile.getKeycloakId(),
                userProfile.getName(),
                userProfile.getLastname(),
                userProfile.getPublicEmail(),
                userProfile.getPhoneNumber(),
                userProfile.getJobTitle(),
                userProfile.getMotivations(),
                userProfile.getBio(),
                userProfile.getLocation(),
                userProfile.getIsVolunteer(),
                userProfile.getUpVotes(),
                userProfile.getPastExperience().stream()
                        .map(
                                this::toPastExperienceResponse
                        ).collect(Collectors.toSet())
        );
    }

    public PastExperienceResponse toPastExperienceResponse(PastExperience experience) {
        return new PastExperienceResponse(
                experience.getId(),
                experience.getOrganizationName(),
                experience.getYears()
        );
    }
}
