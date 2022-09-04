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

import com.google.gson.Gson;
import com.hotel.management.dto.RoomDto;
import com.hotel.management.entity.Room;
import com.hotel.management.services.RoomServiceImpl;

@ExtendWith(SpringExtension.class)
@WebMvcTest(RoomRestController.class)
class RoomRestControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RoomServiceImpl roomServiceImpl;

	@Autowired
	private Gson gson;

	@Test
	void testGetAllRooms() throws Exception {

		List<RoomDto> listRooms = new ArrayList<>();
		listRooms.add(getRoomDto());

		doReturn(listRooms).when(roomServiceImpl).showAllRooms();

		mockMvc.perform(get("/rooms")).andExpect(status().isOk());

	}

	@Test
	void testAddRoom() throws Exception {

		Room room = getRoom();

		RoomDto roomDto = getRoomDto();

		when(roomServiceImpl.saveRoom(room)).thenReturn(roomDto);

		String roomJson = gson.toJson(roomDto);

		mockMvc.perform(post("/rooms").contentType(MediaType.APPLICATION_JSON).content(roomJson))
				.andExpect(status().isCreated());

	}

	@Test
	void testUpdateRoom() throws Exception {

		Room room = getRoom();

		RoomDto roomDto = getRoomDto();

		when(roomServiceImpl.updateRoom(room)).thenReturn(roomDto);

		String roomJson = gson.toJson(roomDto);

		mockMvc.perform(put("/rooms").contentType(MediaType.APPLICATION_JSON).content(roomJson))
				.andExpect(status().isOk());
	}

	@Test
	void testDeleteRoom() throws Exception {

		when(roomServiceImpl.deleteRoom(Mockito.anyInt())).thenReturn(true);

		mockMvc.perform(delete("/rooms/111")).andExpect(status().isOk());

	}

	@Test
	void testBookRoom() throws Exception {

		when(roomServiceImpl.bookRoom(Mockito.anyString(), Mockito.anyInt())).thenReturn("Room Booked");

		mockMvc.perform(put("/rooms/xyz@gmail.com/508")).andExpect(status().isOk());

	}

	Room getRoom() {
		Room room = new Room();
		room.setAvailablity(true);
		room.setId(1);
		room.setPrice(1000);
		room.setType("Dorm");

		return room;
	}

	RoomDto getRoomDto() {
		RoomDto room = new RoomDto();
		room.setAvailablity(true);
		room.setPrice(1000);
		room.setType("Dorm");

		return room;
	}

}
