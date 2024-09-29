package com.hackyeah2024.projects.config;

import com.hackyeah2024.projects.project.Project;
import com.hackyeah2024.projects.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Component
public class ProjectSeeder implements CommandLineRunner {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectSeeder(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedProjects();
    }

    private void seedProjects() {
        Set<Project> projects = new HashSet<>();
        Random random = new Random();

        for (int i = 1; i <= 30; i++) {
            Project project = Project.builder()
                    .name("Project " + i)
                    .description("Description for project " + i)
                    .ngoID((long) (random.nextInt(3) + 1)) // Assuming you have 3 NGOs with IDs 1, 2, 3
                    .desiredBudget(random.nextInt(100000) + 10000) // Random budget between 10,000 and 110,000
                    .location("Location " + i)
                    .status(i % 2 == 0 ? "Active" : "Planned") // Alternate between Active and Planned
                    .startDate(LocalDateTime.now().plusDays(random.nextInt(30)))
                    .endDate(LocalDateTime.now().plusDays(random.nextInt(365) + 30)) // Random end date
                    .estimatedVolunteers(random.nextInt(20) + 5) // Random estimated volunteers between 5 and 25
                    .actualVolunteers(random.nextInt(20)) // Random actual volunteers
                    .category(i % 3 == 0 ? "Education" : (i % 3 == 1 ? "Health" : "Environment")) // Random categories
                    .build();

            projects.add(project);
        }

        projectRepository.saveAll(projects);
    }
}
