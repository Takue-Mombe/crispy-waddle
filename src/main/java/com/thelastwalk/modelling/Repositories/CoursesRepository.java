package com.thelastwalk.modelling.Repositories;

import com.thelastwalk.modelling.Models.Courses;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CoursesRepository extends JpaRepository<Courses,Long> {
}
