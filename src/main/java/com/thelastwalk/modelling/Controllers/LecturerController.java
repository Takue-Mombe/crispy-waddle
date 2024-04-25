package com.thelastwalk.modelling.Controllers;

import com.thelastwalk.modelling.Models.Courses;
import com.thelastwalk.modelling.Models.Lecturer;
import com.thelastwalk.modelling.Models.Marks;
import com.thelastwalk.modelling.Services.CourseService;
import com.thelastwalk.modelling.Services.LecturerService;
import com.thelastwalk.modelling.Services.MarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {
    private final CourseService courseService;
    private final LecturerService lecturerService;
    private final MarksService marksService;

    @Autowired
    public LecturerController(CourseService courseService, LecturerService lecturerService, MarksService marksService) {
        this.courseService = courseService;
        this.lecturerService = lecturerService;
        this.marksService = marksService;
    }

    @GetMapping("/list")
    public String showLecturerCoursesForm(Model model) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        return "Lecturer/InputMarks";
    }

    @PostMapping("/list")
    public String showLecturerCourses(@RequestParam("lecturerId") Long lecturerId, Model model) {
        Lecturer lecturer = lecturerService.getLecturerById(lecturerId)
                .orElseThrow(() -> new IllegalArgumentException("Lecturer not found"));
        model.addAttribute("lecturer", lecturer);
        model.addAttribute("courses", lecturer.getCourses());
        return "Lecturer/InputMarks";
    }

    @PostMapping("/course")
    public String showCourseStudents(@RequestParam("lecturerId") Long lecturerId, @RequestParam("courseId") Long courseId, Model model) {
        Lecturer lecturer = lecturerService.getLecturerById(lecturerId)
                .orElseThrow(() -> new IllegalArgumentException("Lecturer not found"));

        Courses course = courseService.getCourseById(courseId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        model.addAttribute("lecturer", lecturer);
        model.addAttribute("course", course);
        model.addAttribute("students", course.getProgram().getStudents());

        return "Lecturer/InputMarks";
    }

    @PostMapping("/submitMarks")
    public String submitMarks(@RequestParam("courseId") Long courseId, @ModelAttribute("marks") List<Marks> marks) {

        marksService.saveAllMarks(marks);
        return "redirect:/lecturer/list";
    }
}
