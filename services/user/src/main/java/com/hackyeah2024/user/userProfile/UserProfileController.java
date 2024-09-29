package com.hackyeah2024.user.userProfile;

import com.hackyeah2024.user.userProfile.requests.AddPastExperienceRequest;
import com.hackyeah2024.user.userProfile.requests.AddUserProfileRequest;
import com.hackyeah2024.user.userProfile.requests.EditUserProfileRequest;
import com.hackyeah2024.user.userProfile.responses.RichUserProfileResponse;
import com.hackyeah2024.user.userProfile.responses.UserProfileResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hackyeah2024.user.userProfile.requests.PopulateRequest;
import com.hackyeah2024.user.userProfile.requests.PopulateByKeycloakRequest;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/user-profiles")
public class UserProfileController {

    private final UserProfileService userProfileService;



    @PostMapping
    public ResponseEntity<UserProfileResponse> createUserProfile(@RequestBody AddUserProfileRequest requestDto) {
        UserProfileResponse response = userProfileService.createUserProfile(requestDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/volunteers")
    public ResponseEntity<List<RichUserProfileResponse>> getVolunteers() {
        var result = userProfileService.getVolunteers();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/rich-profile/{id}")
    public ResponseEntity<RichUserProfileResponse> getRichUserProfile(@PathVariable Long id) {
        RichUserProfileResponse responseDto = userProfileService.getRichUserProfile(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/by-keycloak-id/{id}")
    public ResponseEntity<RichUserProfileResponse> getUserProfilebyKeycloak(@PathVariable String keycloakID) {
        RichUserProfileResponse responseDto = userProfileService
                .getUserProfileByKeycloakID(keycloakID);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserProfileResponse> getUserProfile(@PathVariable Long id) {
        UserProfileResponse responseDto = userProfileService.getUserProfile(id);
        return ResponseEntity.ok(responseDto);
    }

    @GetMapping
    public ResponseEntity<List<UserProfileResponse>> getAllUserProfiles() {
        List<UserProfileResponse> response = userProfileService.getAllUserProfiles();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserProfileResponse> updateUserProfile(
            @PathVariable Long id,
            @RequestBody EditUserProfileRequest requestDto) {
        UserProfileResponse responseDto = userProfileService.updateUserProfile(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/{id}/upvote")
    public ResponseEntity<UserProfileResponse> upVoteUserProfile(@PathVariable Long id) {
        UserProfileResponse responseDto = userProfileService.upVoteUser(id);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/{id}/experience")
    public ResponseEntity<RichUserProfileResponse> addPreviousExperience(
            @PathVariable Long id,
            @RequestBody AddPastExperienceRequest request) {
        RichUserProfileResponse responseDto = userProfileService.addPreviousExperience(id, request);
        return ResponseEntity.ok(responseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserProfile(@PathVariable Long id) {
        userProfileService.deleteUserProfile(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/populate")
    public ResponseEntity<List<UserProfile>> populateProjects(
            @RequestBody PopulateRequest requestData
    ) {
        List<UserProfile> projects = userProfileService
                .getProjectsByIndexes(requestData);
        return ResponseEntity.ok(projects);
    }

    @PostMapping("/populateByKeycloak")
    public ResponseEntity<List<UserProfile>> populateProjectsByKeycloak(
            @RequestBody PopulateByKeycloakRequest requestData
    ) {
        List<UserProfile> projects = userProfileService
                .getProjectsByKeycloakIndexes(requestData);
        return ResponseEntity.ok(projects);
    }

}