package com.hackyeah2024.projects.project;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "stage")
public class Stage {

    @Id
    @SequenceGenerator(
            name = "stage_sequence",
            sequenceName = "stage_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stage_sequence"
    )
    private Long id;

    private String name;

    @Column(nullable = false)
    private Integer stageOrder; // To define the order of stages


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;
}
