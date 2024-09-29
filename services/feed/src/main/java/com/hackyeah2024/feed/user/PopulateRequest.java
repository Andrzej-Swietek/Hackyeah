package com.hackyeah2024.feed.user;

import java.util.List;

public record PopulateRequest(
        List<Integer> indexes
) {
}
