package com.employe_service.demo.service;

import com.employe_service.demo.entities.Employe;
import com.employe_service.demo.metier.EmpImplMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeRestService {
    @Autowired
    private EmpImplMetier empImplMetier;

    @PostMapping("/employees")
    public ResponseEntity<Employe>  addEmploye(@RequestBody Employe e) {
        Employe employe = empImplMetier.addEmploye(e);
        return new ResponseEntity<>(employe, HttpStatus.CREATED);
    }
    @GetMapping("/employees")
    public ResponseEntity<List<Employe>> listEmploye() {
        List<Employe> employees = empImplMetier.listEmploye();
        return new ResponseEntity<>(employees,HttpStatus.OK);
    }
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employe>  getEmploye(@PathVariable Long id) {
        Employe employe = empImplMetier.getEmploye(id);
        return new ResponseEntity<>(employe,HttpStatus.OK);
    }
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<?> delEmploye(@PathVariable Long id) {
        empImplMetier.delEmploye(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employe> updateEmploye(@RequestBody Employe e, @PathVariable Long id) {
             Employe employe =   empImplMetier.updateEmploye(e, id);
                return new ResponseEntity<>(employe,HttpStatus.OK);
    }
   /* @GetMapping("/employes/{pageNum}/{pageSize}")
    public List<Employe> listEmployePage(@PathVariable int pageNum, @PathVariable int pageSize) {
        return empImplMetier.listEmployePage(pageNum, pageSize);
    }*/
    @GetMapping("/employees/{pageNum}/{pageSize}")
    public List<Employe> listEmpSort(@PathVariable  int pageNum, @PathVariable int pageSize) {
        return empImplMetier.listEmpSort(pageNum, pageSize);
    }

   /* @GetMapping("/employees/keyword/{keyword}")
    public List<Employe> listEmployeSearch(@PathVariable  String keyword) {
        return empImplMetier.listEmployeSearch(keyword);
    }*/
}
