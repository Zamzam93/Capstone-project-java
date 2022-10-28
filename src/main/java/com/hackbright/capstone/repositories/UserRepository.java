package com.hackbright.capstone.repositories;

import com.hackbright.capstone.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository //  will inject user repository bean to the service layer
public interface UserRepository  extends JpaRepository<User, Long> {

    Optional<com.hackbright.capstone.entities.User> findByUsername(String username);



  // to test if this user exists or not


}
