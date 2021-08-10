package com.employe_service.demo.repositorie;

import com.employe_service.demo.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface ServiceRepository extends JpaRepository<Service,Long> {

}
