package com.thelastwalk.modelling.Controllers;

import com.thelastwalk.modelling.Models.Assessments;
import com.thelastwalk.modelling.Services.AssessmentService;
import com.thelastwalk.modelling.Services.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lecturer")
public class LecturerController {
    private final AssessmentService assessmentService;
    private final CourseService courseService;

    public LecturerController(AssessmentService assessmentService, CourseService courseService) {
        this.assessmentService = assessmentService;
        this.courseService = courseService;
    }

    @GetMapping("/list")
    public String showAddAssessmentForm(Model model) {
        model.addAttribute("assessment", new Assessments());
        model.addAttribute("courses",courseService.getAllCourses());
        return "/Lecturer/addAssessment"; // Thymeleaf template name for adding assessments
    }

    @PostMapping("/add")
    public String addAssessment(@ModelAttribute("assessment") Assessments assessment) {
      Assessments createdAssess= assessmentService.createAssessment(assessment);
        System.out.println(createdAssess.getAssessmentName());
        return "redirect:/lecturer/list";
    }
}
