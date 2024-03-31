package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.jdbc.UserBean;
import com.example.demo.jdbc.UserDao;

//This annotation is used to indicate that a particular class is a service component in the application. 
@Service

//The UserService class depends on the functionality provided by the UserDao class to perform database operations related to users.
public class UserService {

// This dependency is injected into the UserService class using the @Autowired annotation. It means that an instance of UserDao will be automatically instantiated and assigned to the userDao field when the UserService bean is created.
	@Autowired
	UserDao userDao;

// This method retrieves a list of all users from the database by delegating the operation to the UserDao component.
// It simply returns the result from calling the listUsers() method of the UserDao instance.
	public List<UserBean> listUsers() {

		return this.userDao.listUsers();
	}

// This method retrieves a user from the database based on their username by delegating the operation to the UserDao component.
	public UserBean findByUsername(String username) {
//It simply returns the result from calling the findByUsername(username) method of the UserDao instance.
		return this.userDao.findByUsername(username);
	}

// This method creates a new user in the database by delegating the operation to the UserDao component.
	public void createUser(UserBean user) {
// It passes the user object to the createUser(user) method of the UserDao instance to perform the database insertion.
		this.userDao.createUser(user);
	}

}
