package com.hackyeah2024.company.company;


import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(path="/api/v1/company")
public class CompanyController {

    private final CompanyService companyService;

    @GetMapping
    public Page<Company> getAllCompanies(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyService.getAllCompanies(pageable);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<Company> getCompanyByName(@PathVariable String name) {
        Company company = companyService.getCompanyByName(name);
        return ResponseEntity.ok(company);
    }

    @GetMapping("/category/{categoryName}")
    public Page<Company> getCompaniesByCategory(@PathVariable String categoryName,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyService.getCompaniesByCategoryName(categoryName, pageable);
    }

    @GetMapping("/owner/{ownerId}")
    public Page<Company> getCompaniesByOwner(@PathVariable String ownerId,
                                             @RequestParam(defaultValue = "0") int page,
                                             @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyService.getCompaniesByOwnerId(ownerId, pageable);
    }

    @GetMapping("/with-employees")
    public Page<Company> getAllCompaniesWithEmployees(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyService.getAllCompaniesWithEmployees(pageable);
    }

    @GetMapping("/search/{namePart}")
    public Page<Company> searchCompaniesByNamePart(@PathVariable String namePart,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyService.getCompaniesByNamePart(namePart, pageable);
    }

    @GetMapping("/description/{keyword}")
    public Page<Company> getCompaniesByDescription(@PathVariable String keyword,
                                                   @RequestParam(defaultValue = "0") int page,
                                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyService.getCompaniesByDescriptionKeyword(keyword, pageable);
    }

    @GetMapping("/city/{city}")
    public Page<Company> getCompaniesByCity(@PathVariable String city,
                                            @RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return companyService.getCompaniesByCity(city, pageable);
    }

    @GetMapping("/{companyId}/employees")
    public Set<String> getEmployeesByCompanyId(@PathVariable Long companyId) {
        return companyService
                .getEmployeesByCompanyId(companyId);
    }

    @PostMapping
    public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
        return ResponseEntity
                .ok(companyService.saveCompany(company));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity
                .ok()
                .build();
    }

    @PostMapping("/populate")
    public ResponseEntity<List<Company>> populateProjects(@RequestBody PopulateRequest requestData) {
        List<Company> projects = companyService
                .getCompaniesByIndexes(requestData);
        return ResponseEntity.ok(projects);
    }
}
