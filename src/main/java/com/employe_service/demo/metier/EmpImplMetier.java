package com.employe_service.demo.metier;

import com.employe_service.demo.entities.Employe;
import com.employe_service.demo.repositorie.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpImplMetier implements EmployeMetier{
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employe addEmploye(Employe e) {
        return employeeRepository.save(e);
    }

    @Override
    public List<Employe> listEmploye() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employe> listEmployePage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<Employe> pagedResult = employeeRepository.findAll(pageable);
        return pagedResult.toList();
    }

    @Override
    public List<Employe> listEmpSort(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize, Sort.by("tel"));
        Page<Employe> page =  employeeRepository.findAll(pageable);
        return page.toList();
    }

   /* @Override
    public List<Employe> listEmployeSearch(String keyword) {
        if (keyword != null){
            return employeRepository.findAllSearch(keyword);
        }
        return employeRepository.findAll();
    }*/

    @Override
    public Employe getEmploye(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void delEmploye(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employe updateEmploye(Employe e, Long id) {
        return employeeRepository.findById(id).map(
                employe -> {
                    employe.setNom(e.getNom());
                    employe.setAdr(e.getAdr());
                    employe.setTel(e.getTel());
                    employe.setService(e.getService());
                    return employeeRepository.save(employe);
                }
        ).orElseGet(()-> {
            e.setId(id);
            return employeeRepository.save(e);
        });
    }
}
