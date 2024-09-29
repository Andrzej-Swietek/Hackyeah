package com.hackyeah2024.projects.project;

import com.hackyeah2024.projects.project.requests.ProjectRequest;
import com.hackyeah2024.projects.project.requests.StageRequest;
import com.hackyeah2024.projects.project.responses.ProjectResponse;
import com.hackyeah2024.projects.project.responses.StageResponse;
import com.hackyeah2024.projects.project.responses.VolunteerResponse;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProjectMapper {

    public static Project toEntity(ProjectRequest projectRequest) {
        return Project.builder()
                .name(projectRequest.name())
                .description(projectRequest.description())
                .ngoID(projectRequest.ngoID())
                .desiredBudget(projectRequest.desiredBudget())
                .location(projectRequest.location())
                .status(projectRequest.status())
                .startDate(projectRequest.startDate())
                .endDate(projectRequest.endDate())
                .estimatedVolunteers(projectRequest.estimatedVolunteers())
                .actualVolunteers(projectRequest.actualVolunteers())
                .category(projectRequest.category())
                .stages(
                        projectRequest.stages() != null ?
                                projectRequest.stages().stream()
                                        .map(ProjectMapper::toEntity)
                                        .collect(Collectors.toSet())
                                : null
                )
                .build();
    }

    public static ProjectResponse toResponse(Project project) {
        return new ProjectResponse(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getNgoID(),
                project.getDesiredBudget(),
                project.getLocation(),
                project.getStatus(),
                project.getStartDate(),
                project.getEndDate(),
                project.getEstimatedVolunteers(),
                project.getActualVolunteers(),
                project.getCategory(),
                project.getCreatedDate(),
                project.getLastModifiedDate(),
                project.getStages() != null ? project.getStages().stream().map(ProjectMapper::toResponse).collect(Collectors.toSet()) : null,
                project.getCurrentStage() != null ? toResponse(project.getCurrentStage()) : null,
                project.getVolunteers() != null ? project.getVolunteers().stream().map(ProjectMapper::toVolunteerResponse).collect(Collectors.toSet()) : null
                );
    }

    public static Stage toEntity(StageRequest stageRequest) {
        return Stage.builder()
                .name(stageRequest.name())
                .build();
    }

    public static VolunteerResponse toVolunteerResponse(Volunteer volunteer) {
        return new VolunteerResponse(volunteer.getId(), volunteer.getUserId(), volunteer.getLocation(),
                volunteer.getStatus(), volunteer.getStartDate(), volunteer.getEndDate());
    }

    public static StageResponse toResponse(Stage stage) {
        return new StageResponse(stage.getId(), stage.getName(), stage.getStageOrder());
    }
}
