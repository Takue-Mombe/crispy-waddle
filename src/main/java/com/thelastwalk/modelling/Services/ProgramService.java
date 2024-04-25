package com.thelastwalk.modelling.Services;

import com.thelastwalk.modelling.Models.Programs;
import com.thelastwalk.modelling.Repositories.ProgramRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramService {

    private final ProgramRepository programRepository;

    @Autowired
    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    // Create
    public Programs createProgram(Programs program) {
        return programRepository.save(program);
    }

    // Read
    public List<Programs> getAllPrograms() {
        return programRepository.findAll();
    }

    public Optional<Programs> getProgramById(Long id) {
        return programRepository.findById(id);
    }

    // Update
    public Programs updateProgram(Long id, Programs updatedProgram) {
        Programs existingProgram = programRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Program not found with id: " + id));

        existingProgram.setProgramCode(updatedProgram.getProgramCode());
        existingProgram.setProgramName(updatedProgram.getProgramName());
        existingProgram.setSchool(updatedProgram.getSchool());
        existingProgram.setCourses(updatedProgram.getCourses());

        return programRepository.save(existingProgram);
    }

    // Delete
    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }
}
