package com.hotel.management.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import com.hotel.management.entity.Room;
import com.hotel.management.entity.User;
import com.hotel.management.repository.RoomRepository;
import com.hotel.management.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class RoomServiceTest {

	@Mock
	private RoomRepository roomRepository;

	@Mock
	private UserRepository userRepository;

	@Mock
	private ModelMapper modelMapper;

	@InjectMocks
	private RoomServiceImpl roomServiceImpl;

	@Test
	void testSaveRoom() {

		Room room = getRoom();

		when(roomRepository.save(Mockito.any(Room.class))).thenReturn(room);

		roomServiceImpl.saveRoom(room);

		verify(roomRepository).save(room);

	}

	@Test
	void testUpdateRoom() {

		Room room = getRoom();

		when(roomRepository.save(Mockito.any(Room.class))).thenReturn(room);

		roomServiceImpl.updateRoom(room);

		verify(roomRepository).save(room);
	}

	@Test
	void testDeleteRoomTrue() {

		Room room = getRoom();

		when(roomRepository.deleteRoomById(Mockito.anyInt())).thenReturn(1);

		boolean actual = roomServiceImpl.deleteRoom(room.getId());

		assertEquals(true, actual);

	}

	@Test
	void testDeleteRoomFalse() {

		Room room = getRoom();

		when(roomRepository.deleteRoomById(Mockito.anyInt())).thenReturn(-1);

		boolean actual = roomServiceImpl.deleteRoom(room.getId());

		assertEquals(false, actual);

	}

	@Test
	void testShowAllRooms() {

		List<Room> listRooms = new ArrayList<>();

		listRooms.add(getRoom());
		listRooms.add(getRoom());

		when(roomRepository.findAll()).thenReturn(listRooms);

		roomServiceImpl.showAllRooms();

		verify(roomRepository).findAll();

	}

	@Test
	void testBookRoom() {
		Room room = getRoom();
		User user = getUser();
		Optional<Room> optionalRoom = Optional.of(room);

		when(roomRepository.findById(Mockito.anyInt())).thenReturn(optionalRoom);

		when(userRepository.findUserByEmail(Mockito.anyString())).thenReturn(user);

		String status = roomServiceImpl.bookRoom(user.getEmail(), room.getId());

		assertEquals("Room Booked", status);

	}

	Room getRoom() {
		Room room = new Room();
		room.setAvailablity(true);
		room.setId(1);
		room.setPrice(1000);
		room.setType("Dorm");

		return room;
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
