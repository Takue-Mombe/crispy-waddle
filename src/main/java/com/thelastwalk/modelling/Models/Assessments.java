package com.thelastwalk.modelling.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "assessment")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Assessments {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assessmentId;
    @Column
    private int assessmentWeight;
    @Column
    private String assessmentName;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course;
    @OneToMany(mappedBy = "assessment")
    private List<Marks> marks;

}
