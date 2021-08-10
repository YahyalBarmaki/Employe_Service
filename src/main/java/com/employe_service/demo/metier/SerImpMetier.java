package com.employe_service.demo.metier;

import com.employe_service.demo.entities.Service;
import com.employe_service.demo.repositorie.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@org.springframework.stereotype.Service
public class SerImpMetier implements ServiceMetier{
    @Autowired
    ServiceRepository serviceRepository;
    @Override
    public Service addService(Service s) {
        return serviceRepository.save(s);
    }

    @Override
    public List<Service> listService() {
        return serviceRepository.findAll();
    }

   /* @Override

    public List<Service> listServiceSearch(String keyword) {
            if(keyword!= null){
                return serviceRepositorie.findAll2(keyword);
            }

        return serviceRepositorie.findAll();
    }*/

    @Override
    public List<Service> listServicePage(int pageNum, int pageSize) {
        Pageable pageable = PageRequest.of(pageNum,pageSize);
        Page<Service> pagedResult = serviceRepository.findAll(pageable);

        return pagedResult.toList();
    }

    @Override
    public List<Service> listServiceSort(int pageNum, int pageSize, String nomService) {
        Pageable pageable = PageRequest.of(pageNum,pageSize, Sort.by("nomService"));
        Page<Service> pagedResult = serviceRepository.findAll(pageable);

        return pagedResult.toList();

    }

    @Override
    public Service OneService(Long id) {
        return serviceRepository.findById(id).get();
    }

    @Override
    public void DeleteService(Long id) {
        serviceRepository.deleteById(id);
    }

    @Override
    public Service updateSer(Service s, Long id) {
        return serviceRepository.findById(id).map(ser->{
            ser.setNomService(s.getNomService());
            return serviceRepository.save(ser);
        }).orElseGet(()->{
            s.setId(id);
            return serviceRepository.save(s);

        });
    }


}
