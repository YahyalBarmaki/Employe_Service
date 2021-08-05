package com.employe_service.demo;

import com.employe_service.demo.entities.Service;
import com.employe_service.demo.repositorie.ServiceRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeServiceApplication implements CommandLineRunner {
    @Autowired
    ServiceRepositorie serviceRepositorie;

    public static void main(String[] args) {
        SpringApplication.run(EmployeServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       /* serviceRepositorie.save(new Service(null,"Informatique",null));
        serviceRepositorie.save(new Service(null,"Multimédia",null));
        serviceRepositorie.save(new Service(null,"Sérigraphie",null));
        serviceRepositorie.save(new Service(null,"Infographie",null));
        serviceRepositorie.save(new Service(null,"Marketing",null));*/
    }
}
