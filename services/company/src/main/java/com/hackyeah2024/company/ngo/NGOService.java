package com.hackyeah2024.company.ngo;

import com.hackyeah2024.company.company.Company;
import com.hackyeah2024.company.company.CompanyRepository;
import com.hackyeah2024.company.company.PopulateRequest;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NGOService {

    private final NGORepository ngoRepository;

    public NGO getNGOByName(String name) {
        return ngoRepository.findByName(name);
    }

    public Page<NGO> getNGOsByOwnerId(String ownerId, Pageable pageable) {
        return ngoRepository.findByOwnerId(ownerId, pageable);
    }

    public Page<NGO> getNGOsByNamePart(String namePart, Pageable pageable) {
        return ngoRepository.findByNameContainingIgnoreCase(namePart, pageable);
    }

    public Page<NGO> getNGOsByStrategyDescription(String keyword, Pageable pageable) {
        return ngoRepository.findByStrategyDescriptionContainingIgnoreCase(keyword, pageable);
    }

    public Page<NGO> getNGOsByCity(String city, Pageable pageable) {
        return ngoRepository.findByCity(city, pageable);
    }

    public Set<String> getVolunteersByNGOId(Long ngoId) {
        return ngoRepository.getVolunteersByNGOId(ngoId);
    }

    public NGO saveCompany(NGO ngo) {
        return ngoRepository.save(ngo);
    }

    public void deleteCompany(Long id) {
        ngoRepository.deleteById(id);
    }

    public Page<NGO> getAllNGOs(Pageable pageable) {
        return ngoRepository.findAll(pageable);
    }

    public Page<NGO> getAllNGOsWithVolunteers(Pageable pageable) {
        return ngoRepository.findAllNGOsWithVolunteers(pageable);
    }

    public List<NGO> getNGOsByIndexes(PopulateRequest requestData) {
        List<Long> ids = requestData.indexes().stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());
        return ngoRepository.findAllByIds(ids);
    }
}
