package com.hotel.management.controller;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.hotel.management.dto.UserDto;
import com.hotel.management.entity.User;
import com.hotel.management.services.UserServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserRestController.class)
class UserRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private UserServiceImpl userServiceImpl;

	@Test
	void testGetAllUser() throws Exception {
		List<User> usersList = new ArrayList<>();

		doReturn(usersList).when(userServiceImpl).findAllUsers();

		mockMvc.perform(MockMvcRequestBuilders.get("/users")).andExpect(status().isOk());
	}

	@Test
	void testGetUserDetails() throws Exception {

		UserDto userDto = getUserDto();
		doReturn(userDto).when(userServiceImpl).findUserByEmail(Mockito.anyString());

		mockMvc.perform(get("/users/" + userDto.getEmail())).andExpect(status().isOk());
	}

	@Test
	void testRegisterUser() throws Exception {
		UserDto userDto = getUserDto();

		User user = getUser();

		when(userServiceImpl.registerUser(user)).thenReturn(userDto);

		Gson gson = new Gson();
		String userJson = gson.toJson(userDto);

		mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isCreated());
	}

	@Test
	void testUpdateUser() throws Exception {
		UserDto userDto = getUserDto();

		User user = getUser();

		when(userServiceImpl.updateUser(user)).thenReturn(userDto);

		Gson gson = new Gson();
		String userJson = gson.toJson(userDto);

		mockMvc.perform(put("/users").contentType(MediaType.APPLICATION_JSON).content(userJson))
				.andExpect(status().isOk());
	}

	@Test
	void testDeleteUser() throws Exception {

		when(userServiceImpl.deleteUser(Mockito.anyString())).thenReturn(true);

		mockMvc.perform(delete("/users/xyz@gmail.com")).andExpect(status().isOk());
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

	public UserDto getUserDto() {
		UserDto user = new UserDto();
		user.setEmail("shyam@gmail.com");
		user.setFirstName("shyam");
		user.setRole("ADMIN");
		user.setLastName("singh");
		user.setPassword("Shyam@123");

		return user;
	}

}
