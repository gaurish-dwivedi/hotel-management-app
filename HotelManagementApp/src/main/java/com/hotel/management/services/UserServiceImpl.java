package com.hotel.management.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.management.dto.UserDto;
import com.hotel.management.entity.User;
import com.hotel.management.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	ModelMapper modelMapper;

	@Override
	public UserDto registerUser(User user) {

		return modelMapper.map(userRepository.save(user), UserDto.class);
	}

	@Override
	public UserDto updateUser(User user) {

		return modelMapper.map(userRepository.save(user), UserDto.class);
	}

	@Override
	public boolean deleteUser(String userEmail) {

		boolean deletedCheck = true;
		if (userRepository.deleteUserByEmail(userEmail) <= 0)
			deletedCheck = false;

		return deletedCheck;
	}

	@Override
	public List<UserDto> findAllUsers() {

		return modelMapper.map(userRepository.findAll(), new TypeToken<List<UserDto>>() {
		}.getType());

	}

	@Override
	public UserDto findUserByEmail(String email) {
		User currentUser=userRepository.findUserByEmail(email);
		UserDto dtoUserDto = new UserDto();
		if(currentUser!= null)
			return modelMapper.map(currentUser,UserDto.class);
		else
			return dtoUserDto;
	}

}
