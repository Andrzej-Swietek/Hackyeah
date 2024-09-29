package com.hackyeah2024.company.ngo;

import com.hackyeah2024.company.company.Company;
import com.hackyeah2024.company.company.PopulateRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/v1/ngo")
public class NGOController {
    private final NGOService ngoService;

    // Get all NGOs with pagination
    @GetMapping
    public Page<NGO> getAllNGOs(@RequestParam(defaultValue = "0") int page,
                                @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ngoService.getAllNGOs(pageable);
    }

    // Get NGOs by name
    @GetMapping("/name/{name}")
    public ResponseEntity<NGO> getNGOByName(@PathVariable String name) {
        NGO ngo = ngoService.getNGOByName(name);
        return ResponseEntity.ok(ngo);
    }

    // Get NGOs by owner ID with pagination
    @GetMapping("/owner/{ownerId}")
    public Page<NGO> getNGOsByOwnerId(@PathVariable String ownerId,
                                      @RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ngoService.getNGOsByOwnerId(ownerId, pageable);
    }

    // Get NGOs by part of the name with pagination
    @GetMapping("/name/contains")
    public Page<NGO> getNGOsByNamePart(@RequestParam String namePart,
                                       @RequestParam(defaultValue = "0") int page,
                                       @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ngoService.getNGOsByNamePart(namePart, pageable);
    }

    // Get NGOs by strategy description keyword with pagination
    @GetMapping("/strategy")
    public Page<NGO> getNGOsByStrategyDescription(@RequestParam String keyword,
                                                  @RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ngoService.getNGOsByStrategyDescription(keyword, pageable);
    }

    // Get NGOs by city with pagination
    @GetMapping("/city/{city}")
    public Page<NGO> getNGOsByCity(@PathVariable String city,
                                   @RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ngoService.getNGOsByCity(city, pageable);
    }

    // Get all NGOs that have volunteers with pagination
    @GetMapping("/volunteers")
    public Page<NGO> getAllNGOsWithVolunteers(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ngoService.getAllNGOsWithVolunteers(pageable);
    }

    // Get volunteers by NGO ID
    @GetMapping("/{ngoId}/volunteers")
    public ResponseEntity<Set<String>> getVolunteersByNGOId(@PathVariable Long ngoId) {
        Set<String> volunteers = ngoService.getVolunteersByNGOId(ngoId);
        return ResponseEntity.ok(volunteers);
    }

    // Create a new NGO
    @PostMapping
    public ResponseEntity<NGO> createNGO(@RequestBody NGO ngo) {
        NGO createdNGO = ngoService.saveCompany(ngo);
        return ResponseEntity.ok(createdNGO);
    }

    // Update an existing NGO
    @PutMapping("/{id}")
    public ResponseEntity<NGO> updateNGO(@PathVariable Long id, @RequestBody NGO ngo) {
        NGO existingNGO = ngoService.getNGOByName(ngo.getName()); // Assume you fetch by name for this example
        if (existingNGO != null) {
            ngo.setId(id); // Set the existing ID
            NGO updatedNGO = ngoService.saveCompany(ngo);
            return ResponseEntity.ok(updatedNGO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete an NGO by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNGO(@PathVariable Long id) {
        ngoService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/populate")
    public ResponseEntity<List<NGO>> populateProjects(@RequestBody PopulateRequest requestData) {
        List<NGO> projects = ngoService
                .getNGOsByIndexes(requestData);
        return ResponseEntity.ok(projects);
    }
}
