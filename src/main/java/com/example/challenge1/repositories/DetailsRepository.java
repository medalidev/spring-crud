package com.example.challenge1.repositories;

import com.example.challenge1.entites.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetailsRepository extends JpaRepository<UserDetails, Long> {
}
