package com.employe_service.demo.repositorie;

import com.employe_service.demo.entities.AppRole;
import com.employe_service.demo.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {
    AppUser findByUsername(String username);
}
