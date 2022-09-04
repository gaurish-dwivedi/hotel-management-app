package com.hotel.management.repository;

import static org.assertj.core.api.Assertions.assertThat;
import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hotel.management.entity.Room;

@SpringBootTest
@Transactional
class RoomRepositoryTest {

	@Autowired
	private RoomRepository roomRepository;

	@Test
	void testDeleteRoomById() {
		Room room1 = getRoom();

		roomRepository.save(room1);

		roomRepository.deleteRoomById(1);

		assertThat(roomRepository.findById(1)).isEmpty();
	}

	Room getRoom() {
		Room room = new Room();
		room.setAvailablity(true);
		room.setId(1);
		room.setPrice(1000);
		room.setType("Dorm");

		return room;
	}

}
