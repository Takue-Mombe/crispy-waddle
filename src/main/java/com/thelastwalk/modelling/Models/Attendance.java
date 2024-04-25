package com.thelastwalk.modelling.Models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "attendance")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor
public class Attendance {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    @Column
    private int attendanceTotal;
    @ManyToOne
    @JoinColumn(name = "course_id")
    private Courses course;
}
