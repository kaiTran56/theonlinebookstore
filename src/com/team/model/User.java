package com.team.model;

import java.time.LocalDateTime;

public class User {
	private int user_id;

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	private String name;
	private String email;
	private String phone;
	private String dateOfBirth;
	private String address;
	private LocalDateTime created;
	private String password;

	public User(int user_id, String name, String email, String phone, String dateOfBirth, String address,
			LocalDateTime created, String password) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.created = created;
		this.password = password;
	}

	public User(String name, String email, String phone, String dateOfBirth, String address, LocalDateTime created,
			String password) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.created = created;
		this.password = password;
	}

	public User(String name, String email, String phone, String dateOfBirth, String address, LocalDateTime created) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.created = created;
	}

	public User(int user_id, String name, String email, String phone, String address) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
