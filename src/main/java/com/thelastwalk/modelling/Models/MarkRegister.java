package com.thelastwalk.modelling.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import java.util.Date;

@Entity(name = "register")
@AllArgsConstructor@Getter
@Setter@NoArgsConstructor
public class MarkRegister {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int registerValue;
    @Column
    private Date createdAt;
    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;
}
