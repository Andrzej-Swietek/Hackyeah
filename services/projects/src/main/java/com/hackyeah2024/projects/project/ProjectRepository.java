package com.hackyeah2024.projects.project;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

    @Query("SELECT p FROM Project p WHERE p.id IN :ids")
    List<Project> findAllByIds(@Param("ids") List<Long> ids);

    Page<Project> findByNameContainingIgnoreCase(String name, Pageable pageable);

    Page<Project> findByNgoID(Long ngoID, Pageable pageable);

    Page<Project> findByCategoryAndStatus(String category, String status, Pageable pageable);

    Page<Project> findByEstimatedVolunteersBetween(Integer minVolunteers, Integer maxVolunteers, Pageable pageable);
}

