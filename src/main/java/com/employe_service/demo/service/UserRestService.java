package com.employe_service.demo.service;

import com.employe_service.demo.entities.AppRole;
import com.employe_service.demo.entities.AppUser;
import com.employe_service.demo.entities.RoleUserForm;
import com.employe_service.demo.metier.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserRestService {
   private AccountService accountService;

    public UserRestService(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("users")
    public ResponseEntity<List<AppUser>>  allUsers() {
        List<AppUser> appUsers = accountService.allUsers();
        return new ResponseEntity<>(appUsers,HttpStatus.OK);
    }
    @GetMapping("roles")
    public ResponseEntity<List<AppRole>>  allRoles() {
        List<AppRole> appRoles = accountService.allRoles();
        return new ResponseEntity<>(appRoles,HttpStatus.OK);
    }

    @PostMapping("/users/addUser")
    public ResponseEntity<AppUser>  addNewUser(@RequestBody AppUser appUser) {
            AppUser appUser1 = accountService.addNewUser(appUser);
        return new ResponseEntity<>(appUser1,HttpStatus.CREATED);
    }
    @PostMapping("/role/addRole")
    public ResponseEntity<AppRole> addNewRole(@RequestBody AppRole appRole) {
        AppRole appRole1 = accountService.addNewRole(appRole);
        return new ResponseEntity<>(appRole1,HttpStatus.CREATED);
    }
    @PostMapping("role/addRoleToUser")
    public void addRoleToUser(RoleUserForm roleUserForm) {
        accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getUsername());
    }
    @GetMapping("users/username/{username}")
    public AppUser loadUserByUsername(@PathVariable String username) {
        return accountService.loadUserByUsername2(username);
    }
}
