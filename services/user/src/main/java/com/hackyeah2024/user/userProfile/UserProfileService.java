package com.hackyeah2024.user.userProfile;


import com.hackyeah2024.user.exception.UserNotFoundException;
import com.hackyeah2024.user.userProfile.requests.*;
import com.hackyeah2024.user.userProfile.responses.RichUserProfileResponse;
import com.hackyeah2024.user.userProfile.responses.UserProfileResponse;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserProfileService {

    private final UserProfileRepository userProfileRepository;
    private final UserProfileMapper userProfileMapper;

    public UserProfileResponse createUserProfile(AddUserProfileRequest requestDto) {
        UserProfile userProfile = userProfileMapper.toUserProfile(requestDto);
        UserProfile savedProfile = userProfileRepository.save(userProfile);
        return userProfileMapper.toUserProfileResponse(savedProfile);
    }

    public UserProfileResponse getUserProfile(Long id) {
        return userProfileRepository.findById(id)
                .map(userProfileMapper::toUserProfileResponse)
                .orElseThrow(() -> new UserNotFoundException("User Profile Could Not Be Found"));
    }

    public RichUserProfileResponse getUserProfileByKeycloakID(String keycloakID) {
        var profile =  userProfileRepository.findUserProfileByKeycloakId(keycloakID);
        if(profile == null) throw new UserNotFoundException("User Profile Could Not Be Found");
        return userProfileMapper.toRichUserProfileResponse(profile);
    }

    public RichUserProfileResponse getRichUserProfile(Long id) {
        return userProfileRepository.findById(id)
                .map(userProfileMapper::toRichUserProfileResponse)
                .orElseThrow(() -> new UserNotFoundException("User Profile Could Not Be Found"));
    }

    public List<UserProfileResponse> getAllUserProfiles() {
        return userProfileRepository.findAll().stream()
                .map(userProfileMapper::toUserProfileResponse)
                .collect(Collectors.toList());
    }

    public UserProfileResponse updateUserProfile(Long id, EditUserProfileRequest requestDto) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Profile Could Not Be Found"));

        userProfile.setKeycloakId(requestDto.keycloakId());
        userProfile.setName(requestDto.name());
        userProfile.setLastname(requestDto.lastname());
        userProfile.setPublicEmail(requestDto.publicEmail());
        userProfile.setPhoneNumber(requestDto.phoneNumber());
        userProfile.setJobTitle(requestDto.jobTitle());
        userProfile.setMotivations(requestDto.motivations());
        userProfile.setBio(requestDto.bio());
        userProfile.setLocation(requestDto.location());
        userProfile.setIsVolunteer(requestDto.isVolunteer());

        UserProfile updatedProfile = userProfileRepository.save(userProfile);
        return this.userProfileMapper
                .toUserProfileResponse(updatedProfile);
    }

    public void deleteUserProfile(Long id) {
        userProfileRepository.deleteById(id);
    }

    public RichUserProfileResponse addPreviousExperience(Long id, AddPastExperienceRequest requestDto) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Profile Could Not Be Found"));

        PastExperience newExperience = new PastExperience();
        newExperience.setOrganizationName(requestDto.organizationName());
        newExperience.setYears(requestDto.years());
        newExperience.setUserProfile(userProfile);

        userProfile.getPastExperience().add(newExperience);

        UserProfile updatedProfile = userProfileRepository.save(userProfile);
        return userProfileMapper.toRichUserProfileResponse(updatedProfile);
    }

    public UserProfileResponse upVoteUser(Long id) {
        UserProfile userProfile = userProfileRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User Profile Could Not Be Found"));

        userProfile.setUpVotes(userProfile.getUpVotes() + 1);
        UserProfile updatedProfile = userProfileRepository.save(userProfile);
        return userProfileMapper
                .toUserProfileResponse(updatedProfile);
    }

    public List<UserProfile> getProjectsByIndexes(PopulateRequest requestData) {
        List<Long> ids = requestData.indexes().stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());
        return userProfileRepository.findAllByIds(ids);
    }

    public List<UserProfile> getProjectsByKeycloakIndexes(PopulateByKeycloakRequest requestData) {
        List<String> ids = requestData.indexes().stream()
                .map(String::valueOf)
                .collect(Collectors.toList());
        return userProfileRepository.findAllByKeycloakIds(ids);
    }


    public List<RichUserProfileResponse> getVolunteers() {
        return userProfileRepository.findVolunteers().stream()
                .map(userProfileMapper::toRichUserProfileResponse)
                .collect(Collectors.toList());
    }
}
