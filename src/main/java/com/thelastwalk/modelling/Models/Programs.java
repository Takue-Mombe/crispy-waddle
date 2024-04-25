package com.thelastwalk.modelling.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "program")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Programs {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long programId;
    @Column(unique = true)
    private String programCode;
    @Column
    private String programName;
    @ManyToOne
    @JoinColumn(name = "school_id") // This is the foreign key column in the program table
    private School school;
    @OneToMany(mappedBy = "program")
    private List<Courses> courses;
    @OneToMany(mappedBy = "program") // Referring to the "program" field in the Student entity
    private List<Student> students; // List of students enrolled in this program


}
