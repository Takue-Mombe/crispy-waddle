package com.thelastwalk.modelling.Repositories;

import com.thelastwalk.modelling.Models.MarkRegister;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRegisterRepository extends JpaRepository<MarkRegister,Long> {
}
