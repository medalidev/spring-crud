package com.example.challenge1.controllers;

import com.example.challenge1.entites.User;
import com.example.challenge1.reponses.messageResponse;
import com.example.challenge1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/new")
    public messageResponse addUser(@RequestBody User user){
        return service.addNewUser(user);
    }

    @GetMapping("/all")
    public List<User> getAllUsers(){
        Long nb=service.numberOfUser();
        System.out.println(nb);
        return service.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        return service.getUserById(id) ;
    }

    @PutMapping("/{id}")
    public User updateUser( @PathVariable("id") Long id, @RequestBody User user){
        return service.updateUserById(id,user);
    }

    @DeleteMapping("/{id}")
    public messageResponse deleteUser(@PathVariable("id") Long id){
        return service.deleteUserById(id);
    }

    // Affecter Details to user
    @PutMapping("/affect-details/{idUser}/{idDetails}")
    public messageResponse affectUserToUserDetails(@PathVariable("idUser") Long idUser,@PathVariable("idDetails") Long idDetails) {
        String message = service.affectUserToDetails(idUser, idDetails);
        return new messageResponse(message);
    }

    // Affecter Role to user
    @PutMapping("/affect-role/{idUser}/{idRole}")
    public ResponseEntity<messageResponse> affectUserToRole(@PathVariable("idUser") Long idUser,@PathVariable("idRole") long idRole) {
        String message = this.service.affectUserToRole(idUser, idRole);
        return new ResponseEntity<>(new messageResponse(message), HttpStatus.OK);
    }
}
