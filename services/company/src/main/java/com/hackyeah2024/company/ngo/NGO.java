package com.hackyeah2024.company.ngo;


import com.hackyeah2024.company.company.Address;
import com.hackyeah2024.company.company.Contact;
import com.hackyeah2024.company.company.Employee;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ngo")
public class NGO {

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
    private String strategyDescription;
    private String socialGoals;
    private String teamDescription;
    private String ownerId;

    @OneToMany(mappedBy = "ngo", cascade = CascadeType.ALL)
    private List<Contact> contacts = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;

    @OneToMany(mappedBy = "ngo", cascade = CascadeType.ALL)
    private Set<Volunteer> volunteers = new HashSet<>();
}
