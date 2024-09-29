package com.hackyeah2024.feed.user;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;


@FeignClient(
        name = "user-service",
        url = "${application.config.user-url}"
)
public interface UserClient {

    @GetMapping("/api/v1/user-profiles/rich-profile/{user-id}")
    Optional<UserResponse> findCustomerById(@PathVariable("user-id") String userId);


    @GetMapping("/api/v1/user-profiles/by-keycloak-id/{keycloak-id}")
    Optional<UserResponse> findCustomerByKeycloakId(@PathVariable("keycloak-id") String keycloakId);


    @PostMapping("/api/v1/user-profiles/populate")
    Optional<List<UserResponse>> populateUsers(@RequestBody PopulateRequest requestBody);


    @PostMapping("/api/v1/user-profiles/populateByKeycloak")
    Optional<List<UserResponse>> populateUsersByKeycloakId(@RequestBody PopulateByKeycloakRequest requestBody);

}