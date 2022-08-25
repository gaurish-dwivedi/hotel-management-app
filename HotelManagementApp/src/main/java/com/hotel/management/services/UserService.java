package com.hotel.management.services;

import java.util.List;

import com.hotel.management.dto.UserDto;
import com.hotel.management.entity.User;

public interface UserService {

	public UserDto registerUser(User user);

	public UserDto updateUser(User user);

	public boolean deleteUser(String userEmail);

	public List<UserDto> findAllUsers();

	public UserDto findUserByEmail(String email);

}
