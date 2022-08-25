package com.hotel.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotel.management.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

	Room findRoomByType(String type);

}
