package com.hackyeah2024.projects.project;

import com.hackyeah2024.projects.project.requests.PopulateRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Transactional
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final StageRepository stageRepository;

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> getProject(Long id) {
        return projectRepository.findById(id);
    }

    public Page<Project> searchProjects(String name, Long ngoID, String category, String status, Integer minVolunteers, Integer maxVolunteers, Pageable pageable) {
        if (name != null) {
            return projectRepository.findByNameContainingIgnoreCase(name, pageable);
        }
        if (ngoID != null) {
            return projectRepository.findByNgoID(ngoID, pageable);
        }
        if (category != null && status != null) {
            return projectRepository.findByCategoryAndStatus(category, status, pageable);
        }
        if (minVolunteers != null && maxVolunteers != null) {
            return projectRepository.findByEstimatedVolunteersBetween(minVolunteers, maxVolunteers, pageable);
        }
        return projectRepository.findAll(pageable);
    }

    public Project updateProject(Project project) {
        return projectRepository.save(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public void addStageToProject(Long projectId, Stage stage) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found"));
        stage.setProject(project);
        stage.setStageOrder(project.getStages().size() + 1);
        stageRepository.save(stage);
    }

    public Set<Stage> getStagesForProject(Long projectId) {
        return Set.copyOf(stageRepository.findByProjectIdOrderByStageOrderAsc(projectId));
    }

    public void setCurrentStage(Long projectId, Long stageId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException("Project not found"));
        Stage stage = stageRepository.findById(stageId).orElseThrow(() -> new IllegalArgumentException("Stage not found"));
        if (!stage.getProject().getId().equals(projectId)) {
            throw new IllegalArgumentException("Stage does not belong to this project");
        }
        project.setCurrentStage(stage);
        projectRepository.save(project);
    }

    public List<Project> getProjectsByIndexes(PopulateRequest requestData) {
        List<Long> ids = requestData.indexes().stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());
        return projectRepository.findAllByIds(ids);
    }
}
