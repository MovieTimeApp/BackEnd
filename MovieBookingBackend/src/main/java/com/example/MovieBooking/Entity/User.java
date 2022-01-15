package com.example.MovieBooking.Entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import org.springframework.data.annotation.Id;

@Document(collection = "Users")
public class User{
	

	@Id
	private String id;
	private String first_Name;
	private String middle_Name;
	private String last_Name;
	
	@Indexed(unique = true)
	private String email;
	
	private String password;
	
//	public User(String first_Name, String middle_Name, String last_Name, String email, String password) {
//		super();
//		First_Name = first_Name;
//		Middle_Name = middle_Name;
//		Last_Name = last_Name;
//		Email = email;
//		Password = password;
//	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirst_Name() {
		return first_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.first_Name = first_Name;
	}

	public String getMiddle_Name() {
		return middle_Name;
	}

	public void setMiddle_Name(String middle_Name) {
		this.middle_Name = middle_Name;
	}

	public String getLast_Name() {
		return last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.last_Name = last_Name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
