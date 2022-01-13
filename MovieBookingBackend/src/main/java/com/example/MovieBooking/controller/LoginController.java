package com.example.MovieBooking.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.MovieBooking.Entity.User;
import com.example.MovieBooking.ResponseEntity.ErrorResponse;
import com.example.MovieBooking.repository.UserRepository;

import antlr.collections.List;

@RestController
@RequestMapping("/customers")
public class LoginController {

		@Autowired
		UserRepository userRepo;
	
		@GetMapping("/Login")
		@ResponseBody
		public ResponseEntity<Object> fetchCustomer(@RequestParam("email") String email,@RequestParam("password") String password)
		{
			
			//System.out.println(password);
			try {
			User user1 = userRepo.findByEmail(email,password);
			System.out.println(user1.getPassword());
			if(user1.getPassword().equals(password)) {
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(user1);
			}else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Password Wrong","Error10"));
			}
			}catch (NullPointerException e) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("User Not Registered","Error10"));
			}
			
		}
		
		@GetMapping
		public ArrayList<User> fetchALLCustomer()
		{
			return (ArrayList<User>) userRepo.findAll();
		}
			
		//Adding a new customer
		@PostMapping
		public ResponseEntity<Object> createUser(@RequestBody User user) 
		{
			try {
				//User user1 = userRepo.save(user);
				User user2 = userRepo.findByEmail(user.getEmail(),null);
				if(user2!= null) {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ErrorResponse("Email Already Registered","Error10"));
				}else {
					User user1 = userRepo.save(user);
					return new ResponseEntity<>(user1, HttpStatus.CREATED);
				}
			    //return new ResponseEntity<>(user1, HttpStatus.CREATED);
			
			}catch (NullPointerException e) {
				try {
					User user1 = userRepo.save(user);
					return new ResponseEntity<>(user1, HttpStatus.CREATED);
				} catch (Exception e2) {
					return new ResponseEntity<>(e2, HttpStatus.INTERNAL_SERVER_ERROR);
				}
			}
			//This method will persist the details of a customer		
		}
		
		//Updating an existing customer
		@PutMapping("/updatePassword")
		@ResponseBody
		public ResponseEntity<Object> updatePassword(@RequestParam("email") String email, @RequestParam("oldPass") String oldPass, @RequestParam("newPass") String newPass) 
		{
			try {
				User regUser = userRepo.findByEmail(email, null);
				regUser.setPassword(newPass);
				System.out.println(regUser.getPassword());
				User updatedUser = userRepo.save(regUser);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedUser);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
		}
		
			
//		//Deleting a customer
//		@DeleteMapping
//		public String deleteCustomer() 
//		{
//			//This method will delete a customer 
//			return "customer details deleted successfully";
//		}
}
