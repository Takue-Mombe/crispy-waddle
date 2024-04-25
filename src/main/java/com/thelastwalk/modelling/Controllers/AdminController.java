package com.thelastwalk.modelling.Controllers;

import com.thelastwalk.modelling.Models.*;
import com.thelastwalk.modelling.Services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private final CourseService courseService;
    private final LecturerService lecturerService;
    private final SchoolService schoolService;
    private final StudentService studentService;
    private final ProgramService programService;

    public AdminController(CourseService courseService, LecturerService lecturerService, SchoolService schoolService, StudentService studentService, ProgramService programService) {
        this.courseService = courseService;
        this.lecturerService = lecturerService;
        this.schoolService = schoolService;
        this.studentService = studentService;
        this.programService = programService;
    }

    @GetMapping("/dashboard")
    public String startHere(Model model){
        List<Courses>courses=courseService.getAllCourses();
        List<Lecturer>lecturers=lecturerService.getAllLecturers();
        List<Student>students=studentService.getAllStudents();
        List<Programs>programs=programService.getAllPrograms();
        List<School>schools=schoolService.getAllSchools();

        model.addAttribute("courses",courses);
        model.addAttribute("lecturers",lecturers);
        model.addAttribute("students",students);
        model.addAttribute("programs",programs);
        model.addAttribute("schools",schools);

        return "index";
    }
    @GetMapping("/student-add")
    public String viewStudent(Model model){
        List<Programs>programs=programService.getAllPrograms();
        List<Student>students=studentService.getAllStudents();
            model.addAttribute("programs",programs);
        model.addAttribute("students",students);
            return "/admin/students";
    }
    @GetMapping("/lecturerList")
    public String viewLecturer(Model model){
        List<Courses>courses=courseService.getAllCourses();
        List<Lecturer>lecturers=lecturerService.getAllLecturers();
        model.addAttribute("courses",courses);
        model.addAttribute("lecturers",lecturers);
        return "/admin/lecturers";
    }
    @PostMapping("/add")
    public String addLecturer(Lecturer lecturer, @RequestParam("selectedCourses") List<Long> selectedCourses) {
        lecturer.setCourses(courseService.getCoursesById(selectedCourses)); // Assuming you have a method to get courses by their IDs
        lecturerService.createLecturer(lecturer); // Assuming you have a service method to save a lecturer

        // Update courses with the assigned lecturer information
        List<Courses> courses = courseService.getCoursesById(selectedCourses);
        for (Courses course : courses) {
            course.setLecturer(lecturer); // Set the lecturer of the course to the newly added lecturer
            courseService.updateCourse(course.getCourseId(), course); // Update the course with the assigned lecturer information
        }

        return "redirect:/admin/lecturerList"; // Redirect to the add lecturer page after successfully adding the lecturer
    }



    @PostMapping("/save-student")
    public String saveStudent(@ModelAttribute Student student) {
        Student savedStudent = studentService.createStudent(student);
        System.out.println("Saved: " + savedStudent.getStudentId());
        return "redirect:/admin/student-add"; // Redirect to the add student page after saving
    }
}
