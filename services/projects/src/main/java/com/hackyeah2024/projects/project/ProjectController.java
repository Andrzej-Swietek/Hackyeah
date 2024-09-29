package com.hackyeah2024.projects.project;

import com.hackyeah2024.projects.project.requests.PopulateRequest;
import com.hackyeah2024.projects.project.requests.ProjectRequest;
import com.hackyeah2024.projects.project.requests.StageRequest;
import com.hackyeah2024.projects.project.responses.ProjectResponse;
import com.hackyeah2024.projects.project.responses.StageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest projectRequest) {
        Project project = projectService
                .createProject(ProjectMapper.toEntity(projectRequest));
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(ProjectMapper.toResponse(project));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProject(@PathVariable Long id) {
        return projectService.getProject(id)
                .map(project -> ResponseEntity.ok(ProjectMapper.toResponse(project)))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<Page<ProjectResponse>> searchProjects(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Long ngoID,
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Integer minVolunteers,
            @RequestParam(required = false) Integer maxVolunteers,
            Pageable pageable) {
        Page<Project> projects = projectService
                .searchProjects(name, ngoID, category, status, minVolunteers, maxVolunteers, pageable);
        return ResponseEntity.ok(projects.map(ProjectMapper::toResponse));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody ProjectRequest projectRequest) {
        Project project = ProjectMapper.toEntity(projectRequest);
        project.setId(id);
        Project updatedProject = projectService.updateProject(project);
        return ResponseEntity.ok(ProjectMapper.toResponse(updatedProject));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/stages")
    public ResponseEntity<Void> addStageToProject(@PathVariable Long id, @RequestBody StageRequest stageRequest) {
        Stage stage = ProjectMapper.toEntity(stageRequest);
        projectService.addStageToProject(id, stage);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}/stages")
    public ResponseEntity<Set<StageResponse>> getStagesForProject(@PathVariable Long id) {
        Set<Stage> stages = projectService.getStagesForProject(id);
        return ResponseEntity.ok(
                stages.stream()
                        .map(ProjectMapper::toResponse)
                        .collect(Collectors.toSet())
        );
    }

    @PutMapping("/{id}/stages/current")
    public ResponseEntity<Void> setCurrentStage(@PathVariable Long id, @RequestParam Long stageId) {
        projectService.setCurrentStage(id, stageId);
        return ResponseEntity.noContent().build();
    }


    @PostMapping("/populate")
    public ResponseEntity<List<Project>> populateProjects(@RequestBody PopulateRequest requestData) {
        List<Project> projects = projectService
                .getProjectsByIndexes(requestData);
        return ResponseEntity.ok(projects);
    }
}
