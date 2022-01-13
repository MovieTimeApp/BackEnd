package com.example.MovieBooking.Entity;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import org.springframework.data.annotation.Id;

@Document(collection = "Users")
public class User{
	

	@Id
	private String Id;
	private String First_Name;
	private String Middle_Name;
	private String Last_Name;
	
	@Indexed(unique = true)
	private String Email;
	
	private String Password;
	
//	public User(String first_Name, String middle_Name, String last_Name, String email, String password) {
//		super();
//		First_Name = first_Name;
//		Middle_Name = middle_Name;
//		Last_Name = last_Name;
//		Email = email;
//		Password = password;
//	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		this.First_Name = first_Name;
	}

	public String getMiddle_Name() {
		return Middle_Name;
	}

	public void setMiddle_Name(String middle_Name) {
		this.Middle_Name = middle_Name;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		this.Last_Name = last_Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		this.Email = email;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		this.Password = password;
	}
	
	
}
