package com.hackyeah2024.company.company;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public Company getCompanyByName(String name) {
        return companyRepository.findByName(name);
    }

    public Page<Company> getCompaniesByCategoryName(String categoryName, Pageable pageable) {
        return companyRepository.findCompaniesByCategoryName(categoryName, pageable);
    }

    public Page<Company> getCompaniesByOwnerId(String ownerId, Pageable pageable) {
        return companyRepository.findByOwnerId(ownerId, pageable);
    }

    public Page<Company> getAllCompaniesWithEmployees(Pageable pageable) {
        return companyRepository.findAllCompaniesWithEmployees(pageable);
    }

    public Page<Company> getCompaniesByNamePart(String namePart, Pageable pageable) {
        return companyRepository.findByNameContainingIgnoreCase(namePart, pageable);
    }

    public Page<Company> getCompaniesByDescriptionKeyword(String keyword, Pageable pageable) {
        return companyRepository.findByDescriptionContainingIgnoreCase(keyword, pageable);
    }

    public Page<Company> getCompaniesByCity(String city, Pageable pageable) {
        return companyRepository.findByCity(city, pageable);
    }

    public Set<String> getEmployeesByCompanyId(Long companyId) {
        return companyRepository.getEmployeesByCompanyId(companyId);
    }

    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }

    public Page<Company> getAllCompanies(Pageable pageable) {
        return companyRepository.findAll(pageable);
    }

    public List<Company> getCompaniesByIndexes(PopulateRequest requestData) {
        List<Long> ids = requestData.indexes().stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());
        return companyRepository.findAllByIds(ids);
    }
}
