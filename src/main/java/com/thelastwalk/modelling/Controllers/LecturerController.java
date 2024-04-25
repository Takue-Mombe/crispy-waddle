package com.thelastwalk.modelling.Controllers;

import com.thelastwalk.modelling.Models.Assessments;
import com.thelastwalk.modelling.Models.Courses;
import com.thelastwalk.modelling.Models.Lecturer;
import com.thelastwalk.modelling.Models.Student;
import com.thelastwalk.modelling.Services.AssessmentService;
import com.thelastwalk.modelling.Services.CourseService;
import com.thelastwalk.modelling.Services.LecturerService;
import com.thelastwalk.modelling.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {
    private final AssessmentService assessmentService;
    private final CourseService courseService;
    private final StudentService studentService;
    private final LecturerService lecturerService;


    @Autowired
    public LecturerController(AssessmentService assessmentService, CourseService courseService, StudentService studentService, LecturerService lecturerService) {
        this.assessmentService = assessmentService;
        this.courseService = courseService;
        this.studentService = studentService;
        this.lecturerService = lecturerService;
    }

    @GetMapping("/list")
    public String showLecturerCoursesForm(Model model) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        return "Lecturer/InputMarks";
    }

    @PostMapping("/list")
    public String showLecturerCourses(@RequestParam("lecturerId") Long lecturerId, Model model) {
        Optional<Lecturer> optionalLecturer = lecturerService.getLecturerById(lecturerId);
        Lecturer lecturer = optionalLecturer.orElseThrow(() -> new IllegalArgumentException("Lecturer not found"));
        model.addAttribute("lecturer", lecturer);
        model.addAttribute("courses", lecturer.getCourses());
        return "Lecturer/InputMarks";
    }

    @PostMapping("/course")
    public String showCourseStudents(@RequestParam("lecturerId") Long lecturerId, @RequestParam("courseId") Long courseId, Model model) {
        Optional<Lecturer> optionalLecturer = lecturerService.getLecturerById(lecturerId);
        Lecturer lecturer = optionalLecturer.orElseThrow(() -> new IllegalArgumentException("Lecturer not found"));

        Optional<Courses> optionalCourse = courseService.getCourseById(courseId);
        Courses course = optionalCourse.orElseThrow(() -> new IllegalArgumentException("Course not found"));

        model.addAttribute("lecturer", lecturer);
        model.addAttribute("course", course);
        return "Lecturer/InputMarks";
    }
}
