package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.jpa.User;


// extends JpaRepository<User, Integer>: This interface extends the JpaRepository interface provided by Spring Data JPA. It specifies that the repository will handle entities of type User and use Integer as the type of the entity's primary key.
public interface UserRepository extends JpaRepository<User, Integer> {
	
// Declares a method to find a user by their username. the return type is Optional <User> that may be empty if no user is found
    Optional<User> findByUsername(String username);
// This is similat to the previous one. find user by their emailId, and it can me empty.
    Optional<User> findByEmailId(String email);

}
