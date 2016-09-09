package com.neeraj.retail.online.store.dto;

import java.util.Calendar;

public class User {
	private String userId;
	private String password;
	private String firstName;
	private String lastName;
	private String emailId;
	private Calendar dateOfBirth;
	
	public User getDummyUser(){
		
		User user = new User();
		user.userId = "neeraj";
		user.password = "abcdef";
		user.firstName= "Rahul";
		user.lastName= "Mahajan";
		return user;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

}
