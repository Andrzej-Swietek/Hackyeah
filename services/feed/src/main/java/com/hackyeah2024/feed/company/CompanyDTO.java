package com.hackyeah2024.feed.company;

import com.hackyeah2024.feed.employee.EmployeeDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public record CompanyDTO(
        Long id,
        String name,
        String description,
        String ownerId,
        Set<EmployeeDTO> employees,
        Set<CompanyCategoryDTO> categories,
        List<ContactDTO> contacts,
        AddressDTO address
) {
    public CompanyDTO {
        // Default initialization to avoid null pointers
        employees = employees != null ? employees : new HashSet<>();
        categories = categories != null ? categories : new HashSet<>();
    }
}
