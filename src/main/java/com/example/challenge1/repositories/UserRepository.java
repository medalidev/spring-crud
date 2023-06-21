package com.example.challenge1.repositories;

import com.example.challenge1.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

   Optional<User> findByEmail(String email);


    // return True if email already exist
   // boolean existsByEmail(String email);

    // find user by email address
   // User findByEmail(String email);

    @Query("SELECT COUNT(id) FROM User id")
    Long numberOfUsers();


}
