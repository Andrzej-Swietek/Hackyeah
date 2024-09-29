package com.hackyeah2024.projects.project;


import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
@EntityListeners(AuditingEntityListener.class) // For `createdDate` and `lastModifiedDate`
@Table(name = "volunteer")
public class Volunteer {
    @Id
    @SequenceGenerator(
            name = "company_sequence",
            sequenceName = "volunteer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "volunteer_sequence"
    )
    private Long id;

    private String userId;

    private String location;
    private String status; // e.g., "Pending", "Accepted"
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    @ManyToMany(mappedBy = "volunteers", cascade = CascadeType.ALL)
    private Set<Project> projects;

}
