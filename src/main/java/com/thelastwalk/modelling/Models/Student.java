package com.thelastwalk.modelling.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "student")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Student {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;
    @Column(unique = true)
    private String regNumber;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String year_enrolled;
    @Column(unique = true)
    private String personalEmail;
    @Column
    private double semester;
    @ManyToOne
    @JoinColumn(name = "program_id")
    private Programs program;
    @OneToMany(mappedBy = "student")
    private List<Marks> marks;
}
