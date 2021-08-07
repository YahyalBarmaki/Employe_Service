package com.employe_service.demo.metier;

import com.employe_service.demo.entities.Service;

import java.util.List;
public interface ServiceMetier {

    public Service addService(Service s);
    public List<Service> listService();
    public List<Service> listServicePage(int pageNum, int pageSize);
    public List<Service> listServiceSort(int pageNum, int pageSize, String nomService);
    public  Service OneService(Long id);
    public  void DeleteService(Long id);
    public  Service updateSer(Service s, Long id);
};
