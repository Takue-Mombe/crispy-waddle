package com.thelastwalk.modelling.Repositories;

import com.thelastwalk.modelling.Models.Assessments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssessmentsRepository extends JpaRepository<Assessments,Long> {
}
