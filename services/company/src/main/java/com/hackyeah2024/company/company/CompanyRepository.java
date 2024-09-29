package com.hackyeah2024.company.company;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Set;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {

    // Find a company by its name
    Company findByName(String name);

    // Find companies by a specific category name with pagination
    @Query("SELECT c FROM Company c JOIN c.categories cat WHERE cat.name = :categoryName")
    Page<Company> findCompaniesByCategoryName(@Param("categoryName") String categoryName, Pageable pageable);

    // Find all companies with a specific owner with pagination
    Page<Company> findByOwnerId(String ownerId, Pageable pageable);

    // Find all companies that have employees (i.e., non-empty employees set) with pagination
    @Query("SELECT c FROM Company c WHERE SIZE(c.employees) > 0")
    Page<Company> findAllCompaniesWithEmployees(Pageable pageable);

    // Find companies by part of the name (case insensitive) with pagination
    Page<Company> findByNameContainingIgnoreCase(String namePart, Pageable pageable);

    // Find companies by their description containing specific keywords with pagination
    Page<Company> findByDescriptionContainingIgnoreCase(String keyword, Pageable pageable);

    // Find companies by their address city with pagination
    @Query("SELECT c FROM Company c WHERE c.address.city = :city")
    Page<Company> findByCity(@Param("city") String city, Pageable pageable);

    // Get employees for a specific company
    @Query("SELECT c.employees FROM Company c WHERE c.id = :companyId")
    Set<String> getEmployeesByCompanyId(@Param("companyId") Long companyId);

    // Save a company (inherited from JpaRepository)
    <S extends Company> S save(S entity);

    // Delete a company by ID (inherited from JpaRepository)
    void deleteById(Long id);


    @Query("SELECT c FROM Company c WHERE c.id IN :ids")
    List<Company> findAllByIds(@Param("ids") List<Long> ids);

    @Query("SELECT COUNT(c) FROM Company c")
    long getCompanyCount();
}
