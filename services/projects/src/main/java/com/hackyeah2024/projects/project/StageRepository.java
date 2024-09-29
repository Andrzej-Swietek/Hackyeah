package com.hackyeah2024.projects.project;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {

    List<Stage> findByProjectIdOrderByStageOrderAsc(Long projectId);
}
