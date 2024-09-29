package com.hackyeah2024.company.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}