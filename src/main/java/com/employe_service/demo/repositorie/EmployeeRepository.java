package com.employe_service.demo.repositorie;

import com.employe_service.demo.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employe,Long> {
    /*@Query("SELECT e from Employe e where e.nom like %?1%" +
            "OR e.adr like %?1%" +
            "OR e.tel like %?1%")
    public List<Employe> findAllSearch(String keyword);*/

}
