package com.thelastwalk.modelling.Services;

import com.thelastwalk.modelling.Models.Marks;
import com.thelastwalk.modelling.Repositories.MarksRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class MarksService {

    private final MarksRepository marksRepository;

    @Autowired
    public MarksService(MarksRepository marksRepository) {
        this.marksRepository = marksRepository;
    }

    public void saveAllMarks(List<Marks> marks) {
        marksRepository.saveAll(marks);
    }
    public Marks createMarks(Marks marks) {
        return marksRepository.save(marks);
    }

    // Read
    public List<Marks> getAllMarks() {
        return marksRepository.findAll();
    }

    public Optional<Marks> getMarksById(Long id) {
        return marksRepository.findById(id);
    }

    // Update
    public Marks updateMarks(Long id, Marks updatedMarks) {
        Marks existingMarks = marksRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Marks not found with id: " + id));

        existingMarks.setMarkValue(updatedMarks.getMarkValue());
        existingMarks.setStudent(updatedMarks.getStudent());

        return marksRepository.save(existingMarks);
    }

    // Delete
    public void deleteMarks(Long id) {
        marksRepository.deleteById(id);
    }
}

