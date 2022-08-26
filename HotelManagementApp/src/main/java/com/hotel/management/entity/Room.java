package com.hotel.management.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rooms")
public class Room implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Room() {
		super();

	}

	@Id
	@Column(name = "roomId")
	private int id;
	@Column(name = "roomPrice")
	private int price;
	@Column(name = "roomType")
	private String type;
	@Column(name = "roomAvailablity")
	private boolean availablity;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinTable(name = "Bookings", joinColumns = {
			@JoinColumn(name = "roomId", referencedColumnName = "roomId") }, inverseJoinColumns = {
					@JoinColumn(name = "email", referencedColumnName = "email") })
	private User user;

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

	public boolean getAvailablity() {
		return availablity;
	}

	public void setAvailablity(boolean availablity) {
		this.availablity = availablity;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(availablity, id, price, type, user);
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
		return availablity == other.availablity && id == other.id && price == other.price
				&& Objects.equals(type, other.type) && Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "Room [id=" + id + ", price=" + price + ", type=" + type + ", availablity=" + availablity + ", user="
				+ user + "]";
	}

}
