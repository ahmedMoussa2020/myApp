package com.example.demo.jpa;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

// The @Entity annotation marks this class as a persistent entity in the database. This means that objects of this class will be saved as rows in the database table.
@Entity
// The @Table annotation is used to specify the name of the database table associated with this entity. In this case, the name of the table is User
@Table(name = "\"User\"")

// implements Serializable is a marker interface in Java that tells the compiler that the class is serializable.
//  This serialization process converts an object into a stream of bytes, which can then be saved to a file, sent over a network, or stored in a database.
public class User implements Serializable {

//  This is a unique identifier for the class version used in the serialization and deserialization processes.
	private static final long serialVersionUID = 1L;

// This annotation specifies that the field is the primary key of the database table.
	@Id
// @GeneratedValue: This annotation specifies that the value of the primary key is automatically generated by the database. This annotation takes a strategy parameter that specifies the generation strategy. Here, the strategy is GenerationType.IDENTITY.
	@GeneratedValue(strategy = GenerationType.IDENTITY)
// @Column: This annotation specifies the mapping of the annotated field to a column in the database table. Here, the column name is userId.
	@Column(name = "\"userId\"")
	private Integer userId;

	@Column(name = "\"firstName\"")
	private String firstName;

	@Column(name = "\"lastName\"")
	private String lastName;

	private String username;

	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;

	private String phone;

	@Column(name = "\"emailId\"")
	private String emailId;

	@Column(name = "\"emailVerified\"")
	private Boolean emailVerified;

	@Column(name = "\"createdOn\"")
	private Timestamp createdOn;

// JsonInclude(Include.NON_NULL):  Along with the next annotation on this list, JsonInclude() controls how null values are handled during JSON serialization.
// Include.NON_NULL : When passed to the JsonInclude() annotation, this annotation specifies that properties with null values should be excluded from the JSON output.	
	@JsonInclude(Include.NON_NULL)

// @OneToOne:  This annotation specifies a one-to-one relationship between the User entity and the Profile entity.
// mappedBy="user": This annotation specifies that the relationship is mapped by the user field in the Profile entity.
// cascade=CascadeType.ALL : Indicates that any change to the User entity will be cascaded down to the Profile entity.
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Profile profile;

// @JsonIgnore: Indicates that a property should be ignored (i.e., not included) during the serialization/deserialization process. In this case, it specifies that the feeds property should be ignored during JSON serialization.
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<Feed> feeds;

	@JsonIgnore
	@OneToMany(mappedBy = "user")
	private List<FeedMetaData> feedMetaData;

	public User() {
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Boolean getEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(Boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public Timestamp getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Timestamp createdOn) {
		this.createdOn = createdOn;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Feed> getFeeds() {
		return feeds;
	}

	public void setFeeds(List<Feed> feeds) {
		this.feeds = feeds;
	}

	public List<FeedMetaData> getFeedMetaData() {
		return feedMetaData;
	}

	public void setFeedMetaData(List<FeedMetaData> feedMetaData) {
		this.feedMetaData = feedMetaData;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", username="
				+ username + ", password=" + password + ", phone=" + phone + ", emailId=" + emailId + ", emailVerified="
				+ emailVerified + ", createdOn=" + createdOn + "]";
	}

}