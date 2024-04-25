package com.thelastwalk.modelling.Repositories;

import com.thelastwalk.modelling.Models.Marks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarksRepository extends JpaRepository<Marks,Long> {
}
