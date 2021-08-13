package com.employe_service.demo;

import com.employe_service.demo.entities.AppRole;
import com.employe_service.demo.entities.AppUser;
import com.employe_service.demo.metier.AccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class EmployeServiceApplication  {


    public static void main(String[] args) {
        SpringApplication.run(EmployeServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    /*
   @Bean
    CommandLineRunner start(AccountService accountService){
        return args -> {
            accountService.addNewRole(new AppRole(null,"USER"));
            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"EMPLOYEE_MANAGER"));
            accountService.addNewRole(new AppRole(null,"SERVICE_MANAGER"));

            accountService.addNewUser(new AppUser(null,"yaya","12345", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"Yahya","12345", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"Baye","0025", new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"Ndaw","123", new ArrayList<>()));

            accountService.addRoleToUser("yaya","USER");
            accountService.addRoleToUser("yahya","ADMIN");
            accountService.addRoleToUser("Baye","EMPLOYEE_MANAGER");
            accountService.addRoleToUser("Ndaw","SERVICE_MANAGER");

        };
   }
*/
}
