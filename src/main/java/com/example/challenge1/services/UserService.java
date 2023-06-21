package com.example.challenge1.services;

import com.example.challenge1.entites.Role;
import com.example.challenge1.entites.User;
import com.example.challenge1.entites.UserDetails;
import com.example.challenge1.exception.ResourceNotFoundException;
import com.example.challenge1.reponses.messageResponse;
import com.example.challenge1.repositories.DetailsRepository;
import com.example.challenge1.repositories.RoleRepository;
import com.example.challenge1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository  repository;
    @Autowired
    private DetailsRepository detailsRepository;
    @Autowired
    private RoleRepository roleRepository;

    public List<User> getAllUsers(){
        return repository.findAll();
    }

    public User getUserById(Long id){
        return repository.findById(id).orElseThrow() ;
    }

    public messageResponse addNewUser(User user){
      if(repository.findByEmail(user.getEmail())!=null) {
        repository.save(user);
          return new messageResponse("added");
      }else {
          return new messageResponse("invalid mail");
      }

    }

    public User updateUserById(Long id, User user){
        user.setId(id);
        return repository.save(user);
    }

    public messageResponse deleteUserById(Long id){
            repository.deleteById(id);
            return new messageResponse("User deleted successfully!");
    }

    // affect user to details
    public  String affectUserToDetails(Long idUser, Long idDetails) {
        Optional<User> userData = repository.findById(idUser);
        if (userData.isPresent()) {
            User existingUser = userData.orElseThrow(() -> new ResourceNotFoundException("User not found"));
            Optional<UserDetails> detailsData = detailsRepository.findById(idDetails);
            if (detailsData.isPresent()) {
                UserDetails existingDetails = detailsData.orElseThrow(() -> new ResourceNotFoundException("Details not found"));
                existingDetails.setUser(existingUser);
                existingUser.setDetails(existingDetails);
                repository.save(existingUser);
                detailsRepository.save(existingDetails);
            }
        }
        return "User affected to details successfully!";
    }

    // Affecter Role to user
    public String affectUserToRole(Long idUser, Long idRole) {
        System.out.println(idUser );
        System.out.println(idRole);
        Optional<User> userData = this.repository.findById(idUser);

        if (userData.isPresent()) {
            User existingUser = userData.orElseThrow(() -> new ResourceNotFoundException("User not found"));
            Optional<Role> roleData = this.roleRepository.findById(idRole);

            if (roleData.isPresent()) {
                Role existingRole = roleData.orElseThrow(() -> new ResourceNotFoundException("Role not found"));
                Set<Role> roles = existingUser.getRoles();
                roles.add(existingRole);
                existingUser.setRoles(roles);
                this.updateUserById(idUser ,existingUser);
            }
        }
        return "User affected to role successfully!";
    }

   public Long numberOfUser(){
        Long nb=repository.numberOfUsers();
        return nb;
    }

}
