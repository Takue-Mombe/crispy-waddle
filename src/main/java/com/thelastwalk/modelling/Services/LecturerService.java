package com.thelastwalk.modelling.Services;

import com.thelastwalk.modelling.Models.Lecturer;
import com.thelastwalk.modelling.Repositories.LecturerRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class LecturerService {

    private final LecturerRepository lecturerRepository;

    @Autowired
    public LecturerService(LecturerRepository lecturerRepository) {
        this.lecturerRepository = lecturerRepository;
    }

    // Create
    public Lecturer createLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    // Read
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    public Optional<Lecturer> getLecturerById(Long id) {
        return lecturerRepository.findById(id);
    }

    // Update
    public Lecturer updateLecturer(Long id, Lecturer updatedLecturer) {
        Lecturer existingLecturer = lecturerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lecturer not found with id: " + id));

        existingLecturer.setLecturerNumber(updatedLecturer.getLecturerNumber());
        existingLecturer.setFirstName(updatedLecturer.getFirstName());
        existingLecturer.setLastName(updatedLecturer.getLastName());
        existingLecturer.setPersonalEmail(updatedLecturer.getPersonalEmail());

        return lecturerRepository.save(existingLecturer);
    }

    // Delete
    public void deleteLecturer(Long id) {
        lecturerRepository.deleteById(id);
    }
}
