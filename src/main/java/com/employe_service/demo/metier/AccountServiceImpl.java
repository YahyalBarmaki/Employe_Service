package com.employe_service.demo.metier;

import com.employe_service.demo.entities.AppRole;
import com.employe_service.demo.entities.AppUser;
import com.employe_service.demo.repositorie.AppRoleRepository;
import com.employe_service.demo.repositorie.AppUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class AccountServiceImpl implements AccountService,UserDetailsService{

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null)
         {
             log.error("User not found in the database");
             throw new UsernameNotFoundException("User not found in the database");
         }else
        {
            log.info("User found in the dataBase");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        appUser.getAppRoles().forEach(appRole -> {
            authorities.add(new SimpleGrantedAuthority(appRole.getNameRole()));
        });
        return new org.springframework.security.core.userdetails.User(appUser.getUsername(),appUser.getPassword(),authorities);
    }
    @Override
    public AppUser addNewUser(AppUser appUser) {
        log.info("Ajout un user dans la base de données",appUser.getUsername());
        String pw = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }
    @Override
    public AppRole addNewRole(AppRole r) {
        log.info("Ajout un role dans la base de données",r.getNameRole());
        return appRoleRepository.save(r);
    }
    @Override
    public void addRoleToUser(String username, String nameRole) {
        log.info("Ajout un role à un user dans la base de données",username,nameRole);
        AppUser appUser = (AppUser) appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByNameRole(nameRole);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername2(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> allUsers() {
        log.info("Lister les users qui sont dans la base de données");
        return  appUserRepository.findAll();
    }
    @Override
    public List<AppRole> allRoles() {
        log.info("Lister les roles qui sont dans la base de données");
        return appRoleRepository.findAll();
    }


}
