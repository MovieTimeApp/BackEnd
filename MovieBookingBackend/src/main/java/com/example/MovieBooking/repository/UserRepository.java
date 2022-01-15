package com.example.MovieBooking.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.MovieBooking.Entity.User;

public interface UserRepository extends MongoRepository<User, String>{
	
	@Query("{ 'email' : ?0 }")
	User findByEmail(String email,String password);
}
