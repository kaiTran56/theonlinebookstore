package com.team.dao;

import java.util.List;

public interface UserDao<T> {
	List<T> getAll();

	T get(int id);

	T get(String email);

	void edit(T t);

	void insert(T t);

	void delete(String email);
	
	T login(String email, String password);
	
	void changePassword(String email, String password);
}