package com.thelastwalk.modelling.Services;


import com.thelastwalk.modelling.Models.Student;
import com.thelastwalk.modelling.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // Read
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getStudentById(Long id) {
        return studentRepository.findById(id);
    }

    // Update
    public Student updateStudent(Long id, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Student not found with id: " + id));

        existingStudent.setRegNumber(updatedStudent.getRegNumber());
        existingStudent.setFirstName(updatedStudent.getFirstName());
        existingStudent.setLastName(updatedStudent.getLastName());
        existingStudent.setYear_enrolled(updatedStudent.getYear_enrolled());
        existingStudent.setPersonalEmail(updatedStudent.getPersonalEmail());
        existingStudent.setSemester(updatedStudent.getSemester());
        existingStudent.setProgram(updatedStudent.getProgram());

        return studentRepository.save(existingStudent);
    }

    // Delete
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
