package com.employe_service.demo.metier;

import com.employe_service.demo.entities.Service;

import java.util.List;
public interface ServiceMetier {

    public Service addService(Service s);
    public List<Service> listService();
    public  Service OneService(Long id);
    public  void DeleteService(Long id);
    public  Service updateSer(Service s, Long id);
};
