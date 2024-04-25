package com.thelastwalk.modelling.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "lecturer")
@Getter@Setter@AllArgsConstructor@NoArgsConstructor
public class Lecturer {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long lecturerId;
    @Column(unique = true)
    private String lecturerNumber;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column(unique = true)
    private String personalEmail;
    @OneToMany(mappedBy = "lecturer")
    private List<Courses> courses;
}
