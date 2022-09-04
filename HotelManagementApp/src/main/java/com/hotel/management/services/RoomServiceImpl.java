package com.hotel.management.services;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.management.dto.RoomDto;
import com.hotel.management.entity.Room;
import com.hotel.management.entity.User;
import com.hotel.management.repository.RoomRepository;
import com.hotel.management.repository.UserRepository;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {

	@Autowired
	ModelMapper modelMapper;

	@Autowired
	RoomRepository roomRepository;

	@Autowired
	UserRepository userRepository;

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
	public String bookRoom(String email, int roomId) {

		String bookingStatus = RoomService.Not_Booked;

		Room roomBooked = roomRepository.findById(roomId).get();

		if (roomBooked.getAvailablity()) {
			roomBooked.setAvailablity(false);
			bookingStatus = RoomService.Booked;
		}

		User currentUser = userRepository.findUserByEmail(email);

		roomBooked.setUser(currentUser);

		return bookingStatus;

	}

}
