package com.hotel.management.services;

import java.util.List;

import com.hotel.management.dto.RoomDto;

public interface RoomService {

	public RoomDto saveRoom(RoomDto room);

	public RoomDto updateRoom(RoomDto room);

	public RoomDto deleteRoom(RoomDto room);

	public List<RoomDto> showAllRooms();

	public List<RoomDto> showAllRoomsByType(String type);

}
