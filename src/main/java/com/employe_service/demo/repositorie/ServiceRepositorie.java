package com.employe_service.demo.repositorie;

import com.employe_service.demo.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Map;

public interface ServiceRepositorie extends JpaRepository<Service,Long> {

}
