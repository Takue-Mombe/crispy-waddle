package com.thelastwalk.modelling.Services;

import com.thelastwalk.modelling.Models.Courses;
import com.thelastwalk.modelling.Models.Programs;
import com.thelastwalk.modelling.Models.Student;
import com.thelastwalk.modelling.Repositories.CoursesRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final CoursesRepository courseRepository;

    @Autowired
    public CourseService(CoursesRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Create
    public Courses createCourse(Courses course) {
        return courseRepository.save(course);
    }

    // Read
    public List<Courses> getAllCourses() {
        return courseRepository.findAll();
    }

    public Optional<Courses> getCourseById(Long id) {
        return courseRepository.findById(id);
    }


    public List<Student> getStudentsByCourse(Courses course) {
        List<Student> students = new ArrayList<>();
        for (Programs program : course.getProgram().getSchool().getPrograms()) {
            students.addAll(program.getStudents());
        }
        return students;
    }
    public Courses updateCourse(Long id, Courses updatedCourse) {
        Courses existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Course not found with id: " + id));

        existingCourse.setCourseCode(updatedCourse.getCourseCode());
        existingCourse.setCourseName(updatedCourse.getCourseName());
        existingCourse.setProgram(updatedCourse.getProgram());
        existingCourse.setLecturer(updatedCourse.getLecturer());
        existingCourse.setAssessments(updatedCourse.getAssessments());
        existingCourse.setAttendance(updatedCourse.getAttendance());

        return courseRepository.save(existingCourse);
    }

    // Delete
    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public List<Courses> getCoursesById(List<Long> courseIds) {
        return courseRepository.findAllById(courseIds);
    }
}
