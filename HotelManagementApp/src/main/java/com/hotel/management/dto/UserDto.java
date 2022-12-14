package com.hotel.management.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

	private int id;

	private String firstName;

	private String lastName;

	private String email;

	private String password;

	private String role;

}
