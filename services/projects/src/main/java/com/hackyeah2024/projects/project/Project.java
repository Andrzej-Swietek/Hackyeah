package com.hackyeah2024.projects.project;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class) // For `createdDate` and `lastModifiedDate`
@Table(name = "project")
public class Project {

    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "company_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "company_sequence"
    )
    private Long id;

    private String name;
    private String description;

    private Long ngoID;
    private Integer desiredBudget;

    private String location;
    private String status;

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private Integer estimatedVolunteers;
    private Integer actualVolunteers;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "volunteers_project",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "volunteer_id"))
    private Set<Volunteer> volunteers;

    private String category;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Builder.Default
    @OrderBy("stageOrder ASC")
    private Set<Stage> stages = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "current_stage_id")
    private Stage currentStage;

    @CreatedDate
    @Column(updatable = false, nullable = false)
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
}
