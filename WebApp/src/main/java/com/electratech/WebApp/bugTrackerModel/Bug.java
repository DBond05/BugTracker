package com.electratech.WebApp.bugTrackerModel;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
//import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;


@Entity
public class Bug {
	@Id
	@GeneratedValue
 private int id;
	@ManyToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="USER_ID")
 private User user;
 @Size(min=5, message="Enter at least 5 characters")
 private String description;
 private LocalDate dateStamp;
 private boolean isResolved;
 @Size(max=200, message="no more than 200 characters")
 private String resolution;

 
 
public Bug(int id,User user, String description, LocalDate dateStamp, boolean isResolved, String resolution) {
	
	this.id = id;
	this.user = user;
	this.description = description;
	this.dateStamp = dateStamp;
	this.isResolved = isResolved;
	this.resolution = resolution;
	
}


public String getResolution() {
	return resolution;
}

public void setResolution(String resolution) {
	this.resolution = resolution;
}


public User getUser() {
	return user;
}


public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public LocalDate getDateStamp() {
	return dateStamp;
}
public void setDateStamp(LocalDate dateStamp) {
	this.dateStamp = dateStamp;
}
public boolean getIsResolved() {
	return isResolved;
}
public void setResolved(boolean isResolved) {
	this.isResolved = isResolved;
}


@Override
public String toString() {
	return "Bug [id=" + id +  ",  description=" + description + ", dateStamp=" + dateStamp
			+ ", isResolved=" + isResolved + ", resolution=" + resolution + "]";
}
 
 
}
