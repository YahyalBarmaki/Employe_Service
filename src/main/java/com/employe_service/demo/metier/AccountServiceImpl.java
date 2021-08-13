package com.employe_service.demo.metier;

import com.employe_service.demo.entities.AppRole;
import com.employe_service.demo.entities.AppUser;
import com.employe_service.demo.repositorie.AppRoleRepository;
import com.employe_service.demo.repositorie.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;

    private PasswordEncoder passwordEncoder;

    public AccountServiceImpl(AppUserRepository appUserRepository, AppRoleRepository appRoleRepository, PasswordEncoder passwordEncoder) {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pw = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pw));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole r) {

        return appRoleRepository.save(r);
    }

    @Override
    public void addRoleToUser(String username, String nameRole) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByNameRole(nameRole);
        appUser.getAppRoles().add(appRole);

    }

    @Override
    public AppUser loadUserByUsername(AppUser username) {
        return null;
    }

    @Override
    public List<AppUser> allUsers() {

        return  appUserRepository.findAll();
    }

    @Override
    public List<AppRole> allRoles() {
        return appRoleRepository.findAll();
    }
}
