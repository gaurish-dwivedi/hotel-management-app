package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserByEmail(String email);
	
	public Integer deleteUserByEmail(String email);

}
