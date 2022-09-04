package com.hotel.management.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import com.hotel.management.dto.UserDto;
import com.hotel.management.entity.User;
import com.hotel.management.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository userRepository;

	@Mock
	ModelMapper modelMapper;

	@InjectMocks
	private UserServiceImpl userServiceImpl;

	@Test
	void testRegisterUser() {

		User user1 = getUser();

		when(userRepository.save(Mockito.any(User.class))).thenReturn(user1);

		userServiceImpl.registerUser(user1);

		verify(userRepository, times(1)).save(user1);

	}

	@Test
	void testUpdateUser() {

		User user1 = getUser();

		when(userRepository.save(Mockito.any(User.class))).thenReturn(user1);

		when(userRepository.findUserByEmail(Mockito.anyString())).thenReturn(user1);

		userServiceImpl.updateUser(user1);

		verify(userRepository, times(1)).save(user1);
	}

	@Test
	void testDeleteUserTrue() {

		User user = getUser();

		when(userRepository.deleteUserByEmail(Mockito.anyString())).thenReturn(1);

		boolean actual = userServiceImpl.deleteUser(user.getEmail());

		assertEquals(true, actual);

	}

	@Test
	void testDeleteUserFalse() {

		User user = getUser();

		when(userRepository.deleteUserByEmail(Mockito.anyString())).thenReturn(-1);

		boolean actual = userServiceImpl.deleteUser(user.getEmail());

		assertEquals(false, actual);

	}

	@Test
	void testFindAllUsers() {
		List<User> list = new ArrayList<User>();
		list.add(getUser());
		list.add(getUser());
		list.add(getUser());

		when(userRepository.findAll()).thenReturn(list);

		userServiceImpl.findAllUsers();

		verify(userRepository).findAll();

	}

	@Test
	void testFindUserByEmail() {
		User user = getUser();
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setEmail(user.getEmail());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setPassword(user.getPassword());
		userDto.setRole(user.getRole());

		when(userRepository.findUserByEmail(Mockito.anyString())).thenReturn(user);

		when(modelMapper.map(ArgumentMatchers.any(), ArgumentMatchers.any())).thenReturn(userDto);

		UserDto currentUser = userServiceImpl.findUserByEmail(user.getEmail());

		assertEquals(currentUser.getId(), user.getId());

	}

	@Test
	void testFindUserByEmail2() {

		UserDto userDto = new UserDto();

		when(userRepository.findUserByEmail(Mockito.anyString())).thenReturn(null);

		UserDto currentUser = userServiceImpl.findUserByEmail("xyz@gmail.com");

		assertEquals(userDto, currentUser);

	}

	public User getUser() {
		User user = new User();
		user.setEmail("shyam@gmail.com");
		user.setFirstName("shyam");
		user.setRole("ADMIN");
		user.setLastName("singh");
		user.setPassword("Shyam@123");

		return user;
	}

}
