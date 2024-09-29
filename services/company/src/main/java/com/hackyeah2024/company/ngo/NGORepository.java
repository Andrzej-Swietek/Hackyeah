package com.hackyeah2024.company.ngo;

import com.hackyeah2024.company.company.Company;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface NGORepository extends PagingAndSortingRepository<NGO, Long> {
    // Find a ngo by its name
    NGO findByName(String name);

    // Find all ngos with a specific owner with pagination
    Page<NGO> findByOwnerId(String ownerId, Pageable pageable);

    // Find ngos by part of the name (case insensitive) with pagination
    Page<NGO> findByNameContainingIgnoreCase(String namePart, Pageable pageable);

    // Find ngos by their description containing specific keywords with pagination
    Page<NGO> findByStrategyDescriptionContainingIgnoreCase(String keyword, Pageable pageable);

    // Find ngos by their address city with pagination
    @Query("SELECT ngo FROM NGO ngo WHERE ngo.address.city = :city")
    Page<NGO> findByCity(@Param("city") String city, Pageable pageable);

    // Get employees for a specific company
    @Query("SELECT ngo.volunteers FROM NGO ngo WHERE ngo.id = :ngoId")
    Set<String> getVolunteersByNGOId(@Param("ngoId") Long ngoId);

    // Save a ngo (inherited from JpaRepository)
    <S extends NGO> S save(S entity);

    // Delete a ngo by ID (inherited from JpaRepository)
    void deleteById(Long id);

    @Query("SELECT ngo FROM NGO ngo WHERE SIZE(ngo.volunteers) > 0")
    Page<NGO> findAllNGOsWithVolunteers(Pageable pageable);

    @Query("SELECT ngo FROM NGO ngo WHERE ngo.id IN :ids")
    List<NGO> findAllByIds(@Param("ids") List<Long> ids);
}
