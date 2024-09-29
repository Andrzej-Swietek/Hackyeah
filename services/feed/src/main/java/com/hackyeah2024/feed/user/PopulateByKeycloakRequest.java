package com.hackyeah2024.feed.user;

import java.util.List;

public record PopulateByKeycloakRequest(
        List<String> indexes
) {
}
