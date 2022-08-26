package com.hotel.management.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomDto {

	private int roomId;

	private int price;

	private String type;

	private boolean availablity;

}
