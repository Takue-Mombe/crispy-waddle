package com.thelastwalk.modelling.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "marks")
@Getter@Setter
@AllArgsConstructor@NoArgsConstructor

public class Marks {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long markId;
    @Column
    private int markValue;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
