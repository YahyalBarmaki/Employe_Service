package com.employe_service.demo.metier;

import com.employe_service.demo.entities.Employe;
import com.employe_service.demo.repositorie.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EmpImplMetier implements EmployeMetier{
    @Autowired
    EmployeRepository employeRepository;
    @Override
    public Employe addEmploye(Employe e) {
        return employeRepository.save(e);
    }

    @Override
    public List<Employe> listEmploye() {
        return employeRepository.findAll();
    }

    @Override
    public List<Employe> listEmployePage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<Employe> pagedResult = employeRepository.findAll(pageable);
        return pagedResult.toList();
    }

    @Override
    public Employe getEmploye(Long id) {
        return employeRepository.findById(id).get();
    }

    @Override
    public void delEmploye(Long id) {
        employeRepository.deleteById(id);
    }

    @Override
    public Employe updateEmploye(Employe e, Long id) {
        return employeRepository.findById(id).map(
                employe -> {
                    employe.setNom(e.getNom());
                    employe.setAdr(e.getAdr());
                    employe.setTel(e.getTel());
                    employe.setService(e.getService());
                    return employeRepository.save(employe);
                }
        ).orElseGet(()-> {
            e.setId(id);
            return employeRepository.save(e);
        });
    }
}
