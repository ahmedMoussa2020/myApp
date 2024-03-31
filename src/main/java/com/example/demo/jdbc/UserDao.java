package com.example.demo.jdbc;

import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.List;

// UserDao is interact with the database to perform CRUD
// this annotation is used to indicate that a class is a repository which
// typically encapsulates DB access logic
@Repository 
public class UserDao {

	final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	JdbcTemplate jdbcTemplate;

// This method retrieves a list of all users from the database.
	public List<UserBean> listUsers() {

// It constructs an SQL query to select all columns from the "User" table.
		String sql = "SELECT * FROM \"User\"";

		return this.jdbcTemplate.query(sql, new UserMapper());

	}
	
	
// This method retrieves a user from the database based on their username.
	public UserBean findByUsername(String username) {

// It constructs an SQL query to select all columns from the "User" table where the username matches the provided username parameter.
		String sql = "SELECT * FROM \"User\" WHERE username = ?";
// It uses the JdbcTemplate to execute the query and retrieve the results, passing an instance of UserMapper to map each row of the result set to a UserBean object.
		List<UserBean> users = this.jdbcTemplate.query(sql, new UserMapper(), username);
// Returns null if users is empty otherwise, returns the first element in the list
		 return users.isEmpty() ? null : users.get(0);
	}

// This method inserts a new user into the database.
	public void createUser(UserBean user) {
//It constructs an SQL insert statement to insert values into the "User" table.
		String sql = "INSERT INTO \"User\" (\"firstName\", \"lastName\", username, phone, \"emailId\", password, \"emailVerified\", \"createdOn\") VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
// The line is a logging statement that logs the SQL insert query before it is executed. 
		logger.debug("Insert Query: {}", sql);

		/* Executes the Insert Statement */
		this.jdbcTemplate.update(sql, new Object[] { user.getFirstName(), user.getLastName(), user.getUsername(),
				user.getPhone(), user.getEmailId(), user.getPassword(), user.getEmailVerified(), user.getCreatedOn() });

	}
}