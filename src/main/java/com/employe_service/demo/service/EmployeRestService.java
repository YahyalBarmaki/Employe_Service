package com.employe_service.demo.service;

import com.employe_service.demo.entities.Employe;
import com.employe_service.demo.metier.EmpImplMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeRestService {
    @Autowired
    private EmpImplMetier empImplMetier;

    @PostMapping("/employes")
    public Employe addEmploye(@RequestBody Employe e) {
        return empImplMetier.addEmploye(e);
    }
    @GetMapping("/employes")
    public List<Employe> listEmploye() {
        return empImplMetier.listEmploye();
    }
    @GetMapping("/employes/{id}")
    public Employe getEmploye(@PathVariable Long id) {
        return empImplMetier.getEmploye(id);
    }
    @DeleteMapping("/employes/{id}")
    public void delEmploye(@PathVariable Long id) {
        empImplMetier.delEmploye(id);
    }
    @PutMapping("/employes/{id}")
    public Employe updateEmploye(@RequestBody Employe e, @PathVariable Long id) {
        return empImplMetier.updateEmploye(e, id);
    }
    @GetMapping("/employes/{pageNum}/{pageSize}")
    public List<Employe> listEmployePage(@PathVariable int pageNum, @PathVariable int pageSize) {
        return empImplMetier.listEmployePage(pageNum, pageSize);
    }
}
