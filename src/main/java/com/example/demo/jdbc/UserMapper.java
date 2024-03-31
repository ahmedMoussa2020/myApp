package com.example.demo.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

//This means that the UserMapper class will be responsible for mapping rows retrieved from a database result set (ResultSet) into instances of UserBean.
public class UserMapper implements RowMapper<UserBean> {

// ResultSet rs: This parameter represents the result set obtained from executing a database query. It contains the data retrieved from the database.
// int rowNum: This parameter represents the current row number within the result set.

	@Override
	public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {

		/* Create a UserBean object */
		UserBean user = new UserBean();

		/* Populates the UserBean object with data from the resultSet */
		
		//This line retrieves the integer value stored in the "userId" column of the ResultSet (rs) and sets it as the userId attribute of the UserBean (user) object.
		user.setUserId(rs.getInt("userId"));
		// This line retrieves the string value stored in the "firstName" column of the ResultSet and sets it as the firstName attribute of the UserBean.
		user.setFirstName(rs.getString("firstName"));
		
		user.setLastName(rs.getString("lastName"));
		user.setUsername(rs.getString("username"));
		user.setPassword(rs.getString("password"));
		user.setPhone(rs.getString("phone"));
		user.setEmailId(rs.getString("emailId"));
		user.setEmailVerified(rs.getBoolean("emailVerified"));
		user.setCreatedOn(rs.getTimestamp("createdOn"));

		/* Return the populated UserBean object */
		//The return user; simply returns the UserBean object after it has been populated with data from the ResultSet.
		return user;
	}

}
