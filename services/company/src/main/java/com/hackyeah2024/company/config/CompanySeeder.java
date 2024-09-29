package com.hackyeah2024.company.config;

import com.hackyeah2024.company.company.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class CompanySeeder {

    private final CompanyRepository companyRepository;
    private final AddressRepository addressRepository;
    private final CompanyCategoryRepository companyCategoryRepository;

    @PostConstruct
    public void seedDatabase() {
        if (companyRepository.getCompanyCount() == 0) {

            // Create some sample categories
            CompanyCategory techCategory = new CompanyCategory(null, "Technology", new HashSet<>());
            CompanyCategory financeCategory = new CompanyCategory(null, "Finance", new HashSet<>());
            CompanyCategory healthcareCategory = new CompanyCategory(null, "Healthcare", new HashSet<>());
            CompanyCategory retailCategory = new CompanyCategory(null, "Retail", new HashSet<>());
            companyCategoryRepository.saveAll(List.of(techCategory, financeCategory, healthcareCategory, retailCategory));

            // Create 30 companies with sample data
            List<Company> companies = new ArrayList<>();
            for (int i = 1; i <= 30; i++) {
                Address address = Address.builder()
                        .street(i + " Main St")
                        .city("City" + i)
                        .state("State" + i)
                        .zip("1000" + i)
                        .country("Country" + i)
                        .build();
                addressRepository.save(address);

                // Assign categories randomly for more variety
                Set<CompanyCategory> assignedCategories = switch (i % 4) {
                    case 0 -> Set.of(techCategory);
                    case 1 -> Set.of(financeCategory);
                    case 2 -> Set.of(healthcareCategory);
                    case 3 -> Set.of(retailCategory);
                    default -> Set.of(techCategory, financeCategory);
                };

                Company company = Company.builder()
                        .name("Company " + i)
                        .description("This is company number " + i + ", offering great services in various sectors.")
                        .ownerId("owner00" + i)
                        .employees(new HashSet<>())  // Add employees if needed
                        .categories(assignedCategories)
                        .contacts(new ArrayList<>())  // Add contacts if needed
                        .address(address)
                        .build();

                companies.add(company);
            }

            // Save companies to the repository
            for (var c : companies)
                companyRepository.save(c);

            System.out.println("30 companies seeded into the database.");
        }
    }
}
