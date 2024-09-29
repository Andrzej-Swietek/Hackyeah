package com.hackyeah2024.user.userProfile;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "userProfile")
public class UserProfile {
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

    private String keycloakId;

    private String name;
    private String lastname;
    private String publicEmail;
    private String phoneNumber;
    private String jobTitle;

    private String motivations;
    private String bio;

    private String location;
    private Boolean isVolunteer;

    @OneToMany(
            mappedBy = "userProfile",
            cascade = CascadeType.ALL
    )
    private Set<PastExperience> pastExperience = new HashSet<>();

    private Integer upVotes;
}
