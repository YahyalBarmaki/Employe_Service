package com.employe_service.demo.metier;

import com.employe_service.demo.entities.Service;
import com.employe_service.demo.repositorie.ServiceRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@org.springframework.stereotype.Service
public class SerImpMetier implements ServiceMetier{
    @Autowired
    ServiceRepositorie serviceRepositorie;
    @Override
    public Service addService(Service s) {
        return serviceRepositorie.save(s);
    }

    @Override
    public List<Service> listService() {
        return serviceRepositorie.findAll();
    }

    @Override
    public Service OneService(Long id) {
        return serviceRepositorie.findById(id).get();
    }

    @Override
    public void DeleteService(Long id) {
        serviceRepositorie.deleteById(id);
    }

    @Override
    public Service updateSer(Service s, Long id) {
        return serviceRepositorie.findById(id).map(ser->{
            ser.setNomService(s.getNomService());
            return serviceRepositorie.save(ser);
        }).orElseGet(()->{
            s.setId(id);
            return serviceRepositorie.save(s);

        });
    }


}
