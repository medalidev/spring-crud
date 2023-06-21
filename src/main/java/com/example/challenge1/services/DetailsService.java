package com.example.challenge1.services;

import com.example.challenge1.entites.User;
import com.example.challenge1.entites.UserDetails;
import com.example.challenge1.reponses.messageResponse;
import com.example.challenge1.repositories.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailsService {

    @Autowired
    private DetailsRepository detailsRepository;

    public List<UserDetails> getAllUserDetails(){
        return detailsRepository.findAll();
    }

    public UserDetails  getUserDetailsById(Long id){
        return detailsRepository.findById(id).orElse(null);
    }

    public UserDetails addNewUserDetails(UserDetails userDetails){
        return detailsRepository.save(userDetails);
    }

    public UserDetails updateUserDetailsById(Long id, UserDetails userDetails){
        userDetails.setId(id);
        return detailsRepository.save(userDetails);
    }

    public messageResponse deleteUserDetailsById(Long id){
        detailsRepository.deleteById(id);
        return new messageResponse("UserDetails deleted successfully!");
    }
}
