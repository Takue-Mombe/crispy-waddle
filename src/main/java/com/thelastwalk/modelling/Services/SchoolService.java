package com.thelastwalk.modelling.Services;

import com.thelastwalk.modelling.Models.School;
import com.thelastwalk.modelling.Repositories.SchoolRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    // Create
    public School createSchool(School school) {
        return schoolRepository.save(school);
    }

    // Read
    public List<School> getAllSchools() {
        return schoolRepository.findAll();
    }

    public Optional<School> getSchoolById(Long id) {
        return schoolRepository.findById(id);
    }

    // Update
    public School updateSchool(Long id, School updatedSchool) {
        School existingSchool = schoolRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("School not found with id: " + id));

        existingSchool.setSchoolCode(updatedSchool.getSchoolCode());
        existingSchool.setSchoolName(updatedSchool.getSchoolName());
        existingSchool.setPrograms(updatedSchool.getPrograms());

        return schoolRepository.save(existingSchool);
    }

    // Delete
    public void deleteSchool(Long id) {
        schoolRepository.deleteById(id);
    }
}
