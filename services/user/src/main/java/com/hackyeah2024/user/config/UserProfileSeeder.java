package com.hackyeah2024.user.config;

import com.hackyeah2024.user.userProfile.UserProfile;

import com.hackyeah2024.user.userProfile.UserProfileRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class UserProfileSeeder {

    private final UserProfileRepository userProfileRepository;

    @PostConstruct
    public void seedDatabase() {
        if (userProfileRepository.count() == 0) {
            // Create 30 users
            UserProfile[] users = new UserProfile[]{
                    new UserProfile(null, "keycloak-001", "John", "Doe", "johndoe@example.com", "123-456-7890", "Developer", "Motivated to help", "I love coding", "New York", true, new HashSet<>(), 100),
                    new UserProfile(null, "keycloak-002", "Jane", "Smith", "janesmith@example.com", "987-654-3210", "Designer", "Creative mind", "Design is my passion", "Los Angeles", true, new HashSet<>(), 85),
                    new UserProfile(null, "keycloak-003", "Robert", "Brown", "robertbrown@example.com", "555-123-4567", "Project Manager", "Organized and efficient", "I manage large teams", "Chicago", true, new HashSet<>(), 92),
                    new UserProfile(null, "keycloak-004", "Michael", "Davis", "michaeldavis@example.com", "444-567-8901", "Engineer", "Detail-oriented", "Engineering is in my blood", "San Francisco", false, new HashSet<>(), 75),
                    new UserProfile(null, "keycloak-005", "Emily", "Wilson", "emilywilson@example.com", "333-678-1234", "Marketing Specialist", "Driven by success", "Marketing is my strength", "Austin", true, new HashSet<>(), 67),
                    new UserProfile(null, "keycloak-006", "Sarah", "Johnson", "sarahjohnson@example.com", "222-789-4561", "Volunteer Coordinator", "Helping others", "I love organizing volunteers", "Denver", true, new HashSet<>(), 81),
                    new UserProfile(null, "keycloak-007", "David", "Miller", "davidmiller@example.com", "111-890-7890", "HR Manager", "People first", "I manage human resources", "Seattle", false, new HashSet<>(), 50),
                    new UserProfile(null, "keycloak-008", "Olivia", "Taylor", "oliviataylor@example.com", "123-555-7890", "Teacher", "Educating the future", "Teaching is my calling", "Houston", true, new HashSet<>(), 90),
                    new UserProfile(null, "keycloak-009", "Lucas", "Anderson", "lucasanderson@example.com", "456-789-0123", "Volunteer", "Eager to contribute", "I volunteer in many causes", "Dallas", true, new HashSet<>(), 76),
                    new UserProfile(null, "keycloak-010", "Sophia", "Thomas", "sophiathomas@example.com", "555-123-1234", "Data Scientist", "Data-driven solutions", "I analyze complex data", "Miami", false, new HashSet<>(), 62),
                    new UserProfile(null, "keycloak-011", "Daniel", "Jackson", "danieljackson@example.com", "234-789-4561", "Social Worker", "Caring for others", "I work with communities", "Atlanta", true, new HashSet<>(), 80),
                    new UserProfile(null, "keycloak-012", "Emma", "White", "emmawhite@example.com", "987-654-7890", "Software Developer", "Building applications", "Coding is my life", "Boston", false, new HashSet<>(), 72),
                    new UserProfile(null, "keycloak-013", "Ethan", "Harris", "ethanharris@example.com", "555-321-6789", "Entrepreneur", "Creating businesses", "I build startups", "San Diego", false, new HashSet<>(), 66),
                    new UserProfile(null, "keycloak-014", "Isabella", "Martin", "isabellamartin@example.com", "444-555-1234", "Consultant", "Problem-solving", "I consult for NGOs", "Portland", false, new HashSet<>(), 59),
                    new UserProfile(null, "keycloak-015", "William", "Garcia", "williamgarcia@example.com", "333-987-6541", "Volunteer", "Helping communities", "I love giving back", "Phoenix", true, new HashSet<>(), 83),
                    new UserProfile(null, "keycloak-016", "Ava", "Martinez", "avamartinez@example.com", "222-333-4444", "Volunteer", "Passionate volunteer", "I am committed to volunteering", "San Antonio", true, new HashSet<>(), 77),
                    new UserProfile(null, "keycloak-017", "James", "Rodriguez", "jamesrodriguez@example.com", "111-555-6667", "Architect", "Designing the future", "I design sustainable buildings", "Philadelphia", false, new HashSet<>(), 58),
                    new UserProfile(null, "keycloak-018", "Mia", "Lopez", "mialopez@example.com", "123-987-0123", "Volunteer", "Motivated to make a difference", "Volunteering is my mission", "Columbus", true, new HashSet<>(), 79),
                    new UserProfile(null, "keycloak-019", "Alexander", "Gonzalez", "alexgonzalez@example.com", "456-789-5555", "Business Analyst", "Analyzing growth opportunities", "I help businesses grow", "Charlotte", false, new HashSet<>(), 64),
                    new UserProfile(null, "keycloak-020", "Amelia", "Perez", "ameliaperez@example.com", "789-654-1234", "Volunteer", "Volunteering for a cause", "I help NGOs with logistics", "Detroit", true, new HashSet<>(), 71),
                    new UserProfile(null, "keycloak-021", "Liam", "Lewis", "liamlewis@example.com", "555-111-7890", "Photographer", "Capturing moments", "Photography is my passion", "San Jose", false, new HashSet<>(), 55),
                    new UserProfile(null, "keycloak-022", "Benjamin", "Walker", "benjaminwalker@example.com", "987-321-4567", "Doctor", "Caring for health", "I work in healthcare", "Jacksonville", true, new HashSet<>(), 91),
                    new UserProfile(null, "keycloak-023", "Chloe", "Hall", "chloehall@example.com", "654-987-3210", "Volunteer", "Committed to causes", "I focus on environmental causes", "Fort Worth", true, new HashSet<>(), 88),
                    new UserProfile(null, "keycloak-024", "Noah", "Allen", "noahallen@example.com", "111-456-7890", "Lawyer", "Justice for all", "I specialize in nonprofit law", "El Paso", false, new HashSet<>(), 70),
                    new UserProfile(null, "keycloak-025", "Harper", "Young", "harperyoung@example.com", "987-654-7891", "Volunteer", "Volunteering enthusiast", "I work with youth programs", "Memphis", true, new HashSet<>(), 85),
                    new UserProfile(null, "keycloak-026", "Samuel", "King", "samuelking@example.com", "555-789-9870", "Artist", "Creativity is key", "I focus on art for social good", "Las Vegas", false, new HashSet<>(), 63),
                    new UserProfile(null, "keycloak-027", "Ella", "Wright", "ellawright@example.com", "444-333-2221", "Volunteer", "Enthusiastic about change", "I am involved in local NGOs", "Nashville", true, new HashSet<>(), 82),
                    new UserProfile(null, "keycloak-028", "Henry", "Scott", "henryscott@example.com", "333-555-4443", "Chef", "Cooking for a cause", "I use cooking to bring people together", "Baltimore", true, new HashSet<>(), 78),
                    new UserProfile(null, "keycloak-029", "Grace", "Torres", "gracetorres@example.com", "222-999-5555", "Volunteer", "Making a difference", "I support refugee programs", "Milwaukee", true, new HashSet<>(), 89),
                    new UserProfile(null, "keycloak-030", "Lucas", "Hill", "lucashill@example.com", "111-222-3333", "Writer", "Writing for change", "I write about social justice", "Albuquerque", false, new HashSet<>(), 60)
            };

            // Save all users to the repository
            userProfileRepository.saveAll(Arrays.asList(users));

            System.out.println("User profiles seeded into the database.");
        }
    }
}
