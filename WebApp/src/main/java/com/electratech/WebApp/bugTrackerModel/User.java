package com.electratech.WebApp.bugTrackerModel;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int userId;	
private String username;	
private String firstName;	
private String lastName;	
private String password;
private String matchPassword;
private String roles;
@OneToMany(targetEntity=Bug.class, mappedBy="user")
private List<Bug> bugList= new ArrayList<Bug>();

public User () {}

public User(int userId, String username, String firstName, String lastName, String password, String matchPassword, String roles) {
	super();
	this.userId = userId;
	this.username = username;
	this.firstName = firstName;
	this.lastName = lastName;
	this.password = password;
	this.matchPassword = matchPassword;
	this.roles = roles;
}


public int getUserId() {
	return userId;
}
public void setId(int userId) {
	this.userId = userId;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
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
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getMatchPassword() {
	return matchPassword;
}
public void setMatchPassword(String matchPassword) {
	this.matchPassword = matchPassword;
}
public List<Bug> getBugList() {
	return bugList;
}
public void setBugList(List<Bug> bugList) {
	this.bugList = bugList;
}

public String getRoles() {
	return roles;
}

public void setRoles(String roles) {
	this.roles = roles;
}

@Override
public String toString() {
	return "User [userId=" + userId + ", username=" + username + ", firstName=" + firstName + ", lastName=" + lastName
			+ ", password=" + password + ", matchPassword=" + matchPassword + ", roles=" + roles + "]";
}



}
