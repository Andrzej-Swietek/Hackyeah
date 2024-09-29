package com.hackyeah2024.user.userProfile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserProfileRepository extends JpaRepository<UserProfile, Long> {

    public UserProfile findByPublicEmail(String email);

    public UserProfile findUserProfileByKeycloakId(String keycloakId);

    @Query("SELECT u FROM UserProfile u WHERE CONCAT(u.name, ' ', u.lastname) ILIKE :fullName")
    public List<UserProfile> findUserProfileByFullName(@Param("fullName") String fullName);

    @Query("SELECT u FROM UserProfile u WHERE u.isVolunteer = true")
    public List<UserProfile> findVolunteers();

    @Query("SELECT p FROM UserProfile p WHERE p.id IN :ids")
    List<UserProfile> findAllByIds(@Param("ids") List<Long> ids);

    @Query("SELECT p FROM UserProfile p WHERE p.keycloakId IN :ids")
    List<UserProfile> findAllByKeycloakIds(@Param("ids") List<String> ids);

//    <S extends UserProfile> S save(S entity);
}
