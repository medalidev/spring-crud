package com.example.challenge1.controllers;

import com.example.challenge1.entites.User;
import com.example.challenge1.entites.UserDetails;
import com.example.challenge1.reponses.messageResponse;
import com.example.challenge1.services.DetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/details")
public class DetailsController {
    @Autowired
    private DetailsService detailsService;

    @PostMapping("/new")
    public UserDetails addUserDetails(@RequestBody UserDetails userDetails){
        return detailsService.addNewUserDetails(userDetails);
    }

    @GetMapping("/all")
    public List<UserDetails> getAllUserDetails(){

        return detailsService.getAllUserDetails();
    }

    @GetMapping("/{id}")
    public UserDetails getUserDetailsById(@PathVariable Long id){
        return detailsService.getUserDetailsById(id);
    }

    @PutMapping("/{id}")
    public UserDetails updateUser( @PathVariable Long id, @RequestBody UserDetails userDetails){
        return detailsService.updateUserDetailsById(id,userDetails);
    }

    @DeleteMapping("/{id}")
    public messageResponse deleteUser(@PathVariable Long id){
        return detailsService.deleteUserDetailsById(id);
    }


}
