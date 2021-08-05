package com.employe_service.demo.metier;

import com.employe_service.demo.entities.Employe;

import java.util.List;

public interface EmployeMetier {
    public Employe addEmploye(Employe e);
    public List<Employe> listEmploye();
    public Employe getEmploye(Long id);
    void delEmploye(Long id);
    public Employe updateEmploye(Employe e, Long id);
}
