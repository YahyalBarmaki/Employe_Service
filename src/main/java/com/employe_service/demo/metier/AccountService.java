package com.employe_service.demo.metier;

import com.employe_service.demo.entities.AppRole;
import com.employe_service.demo.entities.AppUser;

import java.util.List;

public interface AccountService {
    public AppUser addNewUser(AppUser u);
    public AppRole addNewRole(AppRole r);
    void addRoleToUser(String username,String nameRole);
    AppUser loadUserByUsername2(String username);
    public List<AppUser> allUsers();
    public List<AppRole> allRoles();
}
