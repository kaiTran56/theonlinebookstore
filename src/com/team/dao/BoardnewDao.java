package com.team.dao;

import java.util.List;

public interface BoardnewDao<T> {
	List<T> getAll();

	T get(String title);

	T get(int id);

	void insert(T t);

	void delete(int id);

	void edit(T t);
}
