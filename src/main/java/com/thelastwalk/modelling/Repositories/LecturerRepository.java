package com.thelastwalk.modelling.Repositories;

import com.thelastwalk.modelling.Models.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LecturerRepository extends JpaRepository<Lecturer,Long> {
}
