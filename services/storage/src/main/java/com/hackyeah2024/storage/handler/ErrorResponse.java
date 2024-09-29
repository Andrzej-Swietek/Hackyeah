package com.hackyeah2024.storage.handler;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {

}