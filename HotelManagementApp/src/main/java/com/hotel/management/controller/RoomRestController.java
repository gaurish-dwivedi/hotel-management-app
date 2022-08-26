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

import com.hotel.management.dto.RoomDto;
import com.hotel.management.entity.Room;
import com.hotel.management.services.RoomServiceImpl;

@RestController
@RequestMapping("/rooms")
public class RoomRestController {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	RoomServiceImpl roomServiceImpl;

	@GetMapping
	public ResponseEntity<List<RoomDto>> getAllRooms() {
		return ResponseEntity.status(HttpStatus.OK).body(roomServiceImpl.showAllRooms());

	}

	@PostMapping
	public ResponseEntity<RoomDto> addRoom(@RequestBody RoomDto roomDto) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(roomServiceImpl.saveRoom(modelMapper.map(roomDto, Room.class)));

	}

	@PutMapping
	public ResponseEntity<RoomDto> updateRoom(@RequestBody RoomDto roomDto) {
		return ResponseEntity.status(HttpStatus.OK)
				.body(roomServiceImpl.updateRoom(modelMapper.map(roomDto, Room.class)));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteRoom(@PathVariable("id") int roomId) {
		return ResponseEntity.status(HttpStatus.OK).body(roomServiceImpl.deleteRoom(roomId));

	}

}
