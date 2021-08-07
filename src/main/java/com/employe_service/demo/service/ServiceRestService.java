package com.employe_service.demo.service;

import com.employe_service.demo.entities.Service;
import com.employe_service.demo.metier.ServiceMetier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceRestService {
    @Autowired
    private ServiceMetier serviceMetier;
    @PostMapping("/services")
    public Service addService(@RequestBody Service s) {
        return serviceMetier.addService(s);
    }
    @GetMapping("/services")
    public List<Service> listService() {
        return serviceMetier.listService();
    }

    /*@GetMapping("/services/{pageNum}/{sizeNum}")
    public List<Service> listServicePage(int pageNum, int sizeNum) {
        return serviceMetier.listServicePage(pageNum, sizeNum);
    }*/
    @GetMapping("/services/{id}")
    public Service OneService(@PathVariable Long id) {
        return serviceMetier.OneService(id);
    }
    @DeleteMapping("/services/{id}")
    public void DeleteService(@PathVariable  Long id) {
        serviceMetier.DeleteService(id);
    }
    @PutMapping("/services/{id}")
    public Service updateSer(@RequestBody Service s, @PathVariable Long id) {
        return serviceMetier.updateSer(s, id);
    }

    @GetMapping("/services/{pageNum}/{sizeNum}/{nomService}")
    public List<Service> listServiceSort(@PathVariable int pageNum,@PathVariable int sizeNum,@PathVariable String nomService) {
        return serviceMetier.listServiceSort(pageNum, sizeNum, nomService);
    }
}
