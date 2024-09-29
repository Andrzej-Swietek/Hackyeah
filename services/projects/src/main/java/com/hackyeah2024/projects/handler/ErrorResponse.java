package com.hackyeah2024.projects.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}