package com.example.challenge1.services;

import com.example.challenge1.entites.Post;
import com.example.challenge1.entites.Role;
import com.example.challenge1.reponses.messageResponse;
import com.example.challenge1.repositories.PostRepository;
import com.example.challenge1.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getAllRoles(){
        return roleRepository.findAll();
    }

    public Role  getRoleById(Long id){
        return roleRepository.findById(id).orElse(null);
    }

    public Role addNewRole(Role role){
        return roleRepository.save(role);
    }

    public Role updateRoleById(Long id, Role role){
        role.setId(id);
        return roleRepository.save(role);
    }

    public messageResponse deleteRoleById(Long id){
        roleRepository.deleteById(id);
        return new messageResponse("Role deleted successfully!");
    }
}
