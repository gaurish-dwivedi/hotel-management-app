package com.hotel.management.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.dto.UserDto;
import com.hotel.management.entity.User;
import com.hotel.management.services.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserRestController {

	@Autowired
	UserServiceImpl userServiceImpl;

	@Autowired
	ModelMapper modelMapper;

	@GetMapping
	public ResponseEntity<List<UserDto>> getAllUser() {
		return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.findAllUsers());

	}
	
	@GetMapping({"/{email}"})
	public ResponseEntity<UserDto> getUserDetails(@PathVariable("email") String email)
	{
		return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.findUserByEmail(email));
		
	}

	@PostMapping
	public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(userServiceImpl.registerUser(modelMapper.map(userDto, User.class)));

	}

	@PutMapping
	public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(userServiceImpl.updateUser(modelMapper.map(userDto, User.class)));

	}

	@DeleteMapping("/{email}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable("email") String email)
	{
		
		return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.deleteUser(email));
		
	}

}
