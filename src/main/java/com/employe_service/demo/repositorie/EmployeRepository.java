package com.employe_service.demo.repositorie;

import com.employe_service.demo.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeRepository extends JpaRepository<Employe,Long> {
}
