package com.hotel.management.services;

import java.util.List;

import com.hotel.management.dto.RoomDto;
import com.hotel.management.entity.Room;

public interface RoomService {

	public RoomDto saveRoom(Room room);

	public RoomDto updateRoom(Room room);

	public Boolean deleteRoom(int roomId);

	public List<RoomDto> showAllRooms();

	public List<RoomDto> showAllRoomsByType(String type);

}
