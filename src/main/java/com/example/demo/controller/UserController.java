package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.jpa.User;
import com.example.demo.service.UserService;

import java.sql.Timestamp;
import java.time.Instant;

//it tells the spring this class is a Controller and will process user requests.
@RestController

//This annotation maps requests to handlers in this case it will served /user parameter
@RequestMapping("/user")
public class UserController {

//This variable will be used from the UserController methods to print out the Controllers's information in the console

	final Logger logger = LoggerFactory.getLogger(this.getClass());

// The @Autowired annotation tells Spring to inject a UserService instance into the userService variable: 
	@Autowired
	UserService userService;

// This annotation tells Spring that the testController method will handle
// requests. ln this case, requests with the /user/test parameter will be served
// by the UserController's testController() method.
	@GetMapping("/test")
	public String testController() {

		logger.debug("The testController() method was invoked!");
		return "The FeedApp application is up and running";

	}

//
	@GetMapping("/")
// listUsers() method to get all the existing Users in the database:
	public List<User> listUsers() {

		logger.debug("The listUsers() method was invoked!");
		return this.userService.listUsers();
	}

	@GetMapping("/{username}")
// method to get an existing User from the database: 
//	@GetMapping("/{username}")
	public Optional<User> findByUsername(@PathVariable String username) { //@PathVariable in annotation indicates that the value of the {userId} variable from the URL will be mapped to the userId method parameter.

		logger.debug("The findByUsername() method was invoked!, username={}", username);
		return this.userService.findByUsername(username);
	}

	@GetMapping("/{first}/{last}/{username}/{password}/{phone}/{emailId}")
	public String createUser(@PathVariable String first, @PathVariable String last, @PathVariable String username,
			@PathVariable String password, @PathVariable String phone, @PathVariable String emailId) {

		User user = new User();

		user.setFirstName(first);
		user.setLastName(last);
		user.setUsername(username);
		user.setPassword(password);
		user.setPhone(phone);
		user.setEmailId(emailId);
		user.setEmailVerified(false);
		user.setCreatedOn(Timestamp.from(Instant.now()));

		logger.debug("The createUser() method was invoked!, user={}", user.toString());

		this.userService.createUser(user);

		return "User Created Successfully";
	}
	
	
}
