package com.thelastwalk.modelling.Services;

import com.thelastwalk.modelling.Models.MarkRegister;
import com.thelastwalk.modelling.Repositories.MarkRegisterRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class MarkRegisterService {

    private final MarkRegisterRepository markRegisterRepository;

    @Autowired
    public MarkRegisterService(MarkRegisterRepository markRegisterRepository) {
        this.markRegisterRepository = markRegisterRepository;
    }

    // Create
    public MarkRegister createMarkRegister(MarkRegister markRegister) {
        return markRegisterRepository.save(markRegister);
    }

    // Read
    public List<MarkRegister> getAllMarkRegisters() {
        return markRegisterRepository.findAll();
    }

    public Optional<MarkRegister> getMarkRegisterById(Long id) {
        return markRegisterRepository.findById(id);
    }

    // Update
    public MarkRegister updateMarkRegister(Long id, MarkRegister updatedMarkRegister) {
        MarkRegister existingMarkRegister = markRegisterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Mark Register not found with id: " + id));

        existingMarkRegister.setRegisterValue(updatedMarkRegister.getRegisterValue());
        existingMarkRegister.setCreatedAt(updatedMarkRegister.getCreatedAt());
        existingMarkRegister.setStudent(updatedMarkRegister.getStudent());

        return markRegisterRepository.save(existingMarkRegister);
    }

    // Delete
    public void deleteMarkRegister(Long id) {
        markRegisterRepository.deleteById(id);
    }
}
