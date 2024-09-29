package com.hackyeah2024.projects.project.requests;

import java.util.List;

public record PopulateRequest(
        List<Integer> indexes
) {}