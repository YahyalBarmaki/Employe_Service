package com.employe_service.demo.service;

import com.employe_service.demo.entities.Service;
import com.employe_service.demo.metier.ServiceMetier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceRestService {
    private ServiceMetier serviceMetier;

    public ServiceRestService(ServiceMetier serviceMetier) {
        this.serviceMetier = serviceMetier;
    }

    @PostMapping("/services")
    public ResponseEntity<Service> addService(Service s) {
              Service service =  serviceMetier.addService(s);
              return new ResponseEntity<>(service, HttpStatus.CREATED);
    }
    @GetMapping("/services")
    public ResponseEntity<List<Service>> listService() {
        List <Service>  service= serviceMetier.listService();
        return new ResponseEntity<>(service,HttpStatus.OK);
    }
    @GetMapping("/services/{id}")
    public ResponseEntity<Service> OneService(@PathVariable Long id) {
        Service service = serviceMetier.OneService(id);
        return new ResponseEntity<>(service,HttpStatus.OK);
    }
    @DeleteMapping("/services/{id}")
    public ResponseEntity<?> DeleteService(@PathVariable  Long id) {
      serviceMetier.DeleteService(id);
        return  new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/services/{id}")
    public ResponseEntity<Service> updateSer(@RequestBody Service s, @PathVariable Long id) {
        Service service = serviceMetier.updateSer(s, id);
        return new ResponseEntity<>(service,HttpStatus.OK);
    }

    @GetMapping("/services/{pageNum}/{sizeNum}/{nomService}")
    public List<Service> listServiceSort(@PathVariable int pageNum,@PathVariable int sizeNum,@PathVariable String nomService) {
        return serviceMetier.listServiceSort(pageNum, sizeNum, nomService);
    }
}

