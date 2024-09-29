package com.hackyeah2024.user.userProfile.requests;

import java.util.List;

public record PopulateByKeycloakRequest(
        List<String> indexes
) {
}
