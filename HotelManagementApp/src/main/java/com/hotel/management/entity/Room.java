package com.hotel.management.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room {

	@Id
	@Column(name = "roomId")
	private int id;
	@Column(name = "roomPrice")
	private int price;
	@Column(name = "roomType")
	private String type;
	@Column(name = "roomAvailablity")
	private boolean availablity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvailablity() {
		return availablity;
	}

	public void setAvailablity(boolean availablity) {
		this.availablity = availablity;
	}

	@Override
	public int hashCode() {
		return Objects.hash(availablity, id, price, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return availablity == other.availablity && id == other.id && Objects.equals(price, other.price)
				&& Objects.equals(type, other.type);
	}

	@Override
	public String toString() {
		return "RoomDto [id=" + id + ", price=" + price + ", type=" + type + ", availablity=" + availablity + "]";
	}

}
