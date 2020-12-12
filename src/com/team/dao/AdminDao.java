package com.team.dao;

import java.util.List;

import com.team.model.Admin;

public interface AdminDao<T> {
	public Admin getLogin(String username, String password);

	List<T> getAll();
	
	T get(String username);

	void insert(T t);

	void delete(String t);

	void Edit(T t);
}
