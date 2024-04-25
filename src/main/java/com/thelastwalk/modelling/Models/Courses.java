package com.thelastwalk.modelling.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "courses")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Courses {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column(unique = true)
    private String courseCode;
    @Column
    private String courseName;
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Programs program;
    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;
    @Column
    private double semester;
    @OneToMany(mappedBy = "course")
    private List<Assessments> assessments;
    @OneToMany(mappedBy = "course")
    private List<Assessments> attendance;

}
