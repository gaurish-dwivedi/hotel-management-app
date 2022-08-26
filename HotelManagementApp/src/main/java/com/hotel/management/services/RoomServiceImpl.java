package com.hotel.management.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.management.dto.RoomDto;
import com.hotel.management.entity.Room;
import com.hotel.management.repository.RoomRepository;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	RoomRepository roomRepository;

	@Override
	public RoomDto saveRoom(Room room) {

		return modelMapper.map(roomRepository.save(room), RoomDto.class);
	}

	@Override
	public RoomDto updateRoom(Room room) {

		return modelMapper.map(roomRepository.save(room), RoomDto.class);
	}

	@Override
	public Boolean deleteRoom(int roomId) {

		boolean deletedCheck = true;
		if (roomRepository.deleteRoomById(roomId) <= 0)
			deletedCheck = false;

		return deletedCheck;
	}

	@Override
	public List<RoomDto> showAllRooms() {

		return modelMapper.map(roomRepository.findAll(), new TypeToken<List<RoomDto>>() {
		}.getType());
	}

	@Override
	public List<RoomDto> showAllRoomsByType(String type) {

		return modelMapper.map(roomRepository.findRoomByType(type), new TypeToken<List<RoomDto>>() {
		}.getType());
	}

}
