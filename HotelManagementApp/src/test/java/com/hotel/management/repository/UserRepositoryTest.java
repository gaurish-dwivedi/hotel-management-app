package com.hotel.management.repository;

import static org.junit.jupiter.api.Assertions.*;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotel.management.entity.User;

@SpringBootTest
@Transactional
class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;

	@Test
	void testFindUserByEmail() {

		User user1 = getUser();

		userRepository.save(user1);

		User result = userRepository.findUserByEmail(user1.getEmail());

		assertEquals(user1.getEmail(), result.getEmail());

	}

	@Test
	void testDeleteUserByEmail() {

		User user1 = getUser();

		userRepository.save(user1);

		userRepository.deleteUserByEmail(user1.getEmail());

		assertEquals(null, userRepository.findUserByEmail(user1.getEmail()));

	}

	public User getUser() {
		User user = new User();
		user.setEmail("shyam@gmail.com");
		user.setFirstName("shyam");
		user.setRole("ADMIN");
		user.setId(1);
		user.setLastName("singh");
		user.setPassword("Ram@123");

		return user;
	}

}
