package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jpa.User;
import com.example.demo.repository.UserRepository;
//This annotation is used to indicate that a particular class is a service component in the application. 
@Service

//The UserService class depends on the functionality provided by the UserDao class to perform database operations related to users.
public class UserService {

// This dependency is injected into the UserService class using the @Autowired annotation. It means that an instance of UserDao will be automatically instantiated and assigned to the userDao field when the UserService bean is created.
//	@Autowired
//	UserDao userDao;

// @Autowired UserRepository userRepository;: This line injects an instance of the UserRepository interface into the UserService class. This means that Spring will automatically create and assign an instance of UserRepository to the userRepository field when initializing the UserService bean.
	@Autowired
	UserRepository userRepository;
	
// This method retrieves a list of all users from the database by delegating the operation to the UserDao component.
// It simply returns the result from calling the listUsers() method of the UserDao instance.
	
// This method retrieves a list of all users from the database by calling the findAll() method of the UserRepository interface. Spring Data JPA automatically generates the appropriate query to fetch all users from the database.
	public List<User> listUsers() {
		return this.userRepository.findAll();
	}

// This method retrieves a user from the database based on their username by delegating the operation to the UserDao component.
	
//  This method retrieves a user from the database based on their username by calling the findByUsername(username) method of the UserRepository interface. The method returns an Optional<User>, indicating that the result may or may not contain a user object.
	public Optional<User> findByUsername(String username) {
	
//It simply returns the result from calling the findByUsername(username) method of the UserDao instance.
		
// This method creates a new user in the database by calling the save(user) method of the UserRepository interface. Spring Data JPA automatically determines whether to perform an insert or an update operation based on whether the user entity has a primary key value set.

		return this.userRepository.findByUsername(username);
	}

// This method creates a new user in the database by delegating the operation to the UserDao component.
	public void createUser(User user) {
	
// It passes the user object to the createUser(user) method of the UserDao instance to perform the database insertion.
		this.userRepository.save(user);
	}

}
