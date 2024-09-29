package com.hackyeah2024.company.config;

import com.hackyeah2024.company.ngo.NGO;
import com.hackyeah2024.company.ngo.NGORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class NGOSeeder implements CommandLineRunner {

    private final NGORepository ngoRepository;

    @Autowired
    public NGOSeeder(NGORepository ngoRepository) {
        this.ngoRepository = ngoRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        seedNGOs();
    }

    private void seedNGOs() {
        List<NGO> ngos = Arrays.asList(
                NGO.builder()
                        .name("Helping Hands")
                        .strategyDescription("Empowering communities through education.")
                        .socialGoals("Improve literacy rates in underserved areas.")
                        .teamDescription("A dedicated team of volunteers and educators.")
                        .ownerId("owner1")
                        .build(),
                NGO.builder()
                        .name("Clean Earth Initiative")
                        .strategyDescription("Promoting sustainable environmental practices.")
                        .socialGoals("Reduce plastic waste in local communities.")
                        .teamDescription("Environmental activists and community leaders.")
                        .ownerId("owner2")
                        .build(),
                NGO.builder()
                        .name("Health for All")
                        .strategyDescription("Providing medical care to remote areas.")
                        .socialGoals("Increase access to healthcare services.")
                        .teamDescription("Healthcare professionals and volunteers.")
                        .ownerId("owner3")
                        .build(),
                NGO.builder()
                        .name("Food Security Alliance")
                        .strategyDescription("Fighting hunger and food insecurity.")
                        .socialGoals("Ensure everyone has access to nutritious food.")
                        .teamDescription("Food banks and community organizers.")
                        .ownerId("owner4")
                        .build(),
                NGO.builder()
                        .name("Youth Empowerment")
                        .strategyDescription("Supporting youth through mentoring and resources.")
                        .socialGoals("Encourage leadership and community engagement.")
                        .teamDescription("Mentors and youth advocates.")
                        .ownerId("owner5")
                        .build()
        );

        for(var ngo : ngos)
            ngoRepository.save(ngo);
    }
}

