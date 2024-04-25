package com.thelastwalk.modelling.Services;

import com.thelastwalk.modelling.Models.Assessments;
import com.thelastwalk.modelling.Repositories.AssessmentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssessmentService {

    private final AssessmentsRepository assessmentsRepository;


    @Autowired
    public AssessmentService(AssessmentsRepository assessmentsRepository) {
        this.assessmentsRepository = assessmentsRepository;
    }

    // Create
    public Assessments createAssessment(Assessments assessment) {
        return assessmentsRepository.save(assessment);
    }

    // Read
    public List<Assessments> getAllAssessments() {
        return assessmentsRepository.findAll();
    }

    public Optional<Assessments> getAssessmentById(Long id) {
        return assessmentsRepository.findById(id);
    }

    // Update
    public Assessments updateAssessment(Long id, Assessments updatedAssessment) {
        Assessments existingAssessment = assessmentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Assessment not found with id: " + id));

        existingAssessment.setAssessmentName(updatedAssessment.getAssessmentName());
        existingAssessment.setAssessmentWeight(updatedAssessment.getAssessmentWeight());
        existingAssessment.setCourse(updatedAssessment.getCourse());

        return assessmentsRepository.save(existingAssessment);
    }

    // Delete
    public void deleteAssessment(Long id) {
        assessmentsRepository.deleteById(id);
    }
}
