package com.thelastwalk.modelling.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name = "school")
@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
public class School {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long schoolId;
    @Column
    private String schoolCode;
    @Column
    private String schoolName;
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Programs> programs;
}
