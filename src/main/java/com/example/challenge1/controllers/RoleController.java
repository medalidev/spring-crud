package com.example.challenge1.controllers;

import com.example.challenge1.entites.Post;
import com.example.challenge1.entites.Role;
import com.example.challenge1.reponses.messageResponse;
import com.example.challenge1.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @PostMapping("/new")
    public Role addRole(@RequestBody Role role){
        return roleService.addNewRole(role);
    }

    @GetMapping("/all")
    public List<Role> getAllRoles(){
        return roleService.getAllRoles();
    }

    @GetMapping("/{id}")
    public Role getRoleById(@PathVariable Long id){
        return roleService.getRoleById(id);
    }

    @PutMapping("/{id}")
    public Role updateRole( @PathVariable Long id, @RequestBody Role role){
        return roleService.updateRoleById(id,role);
    }
    @DeleteMapping("/{id}")
    public messageResponse deleteRole(@PathVariable Long id){
        return roleService.deleteRoleById(id);
    }
}
