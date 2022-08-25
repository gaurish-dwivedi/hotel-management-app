package com.hotel.management.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.management.entity.User;

@RestController
public class HelloWorld {
	@RequestMapping("/check")
	public String hello() {
		
		User user=new User();
		user.setId(1); 
		return user.toString();
	}

}
