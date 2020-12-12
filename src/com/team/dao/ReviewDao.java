package com.team.dao;

import java.util.List;

public interface ReviewDao<T> {
	List<T> getAll();

	T get(int id);

	T get(String name);

	void insert(T t);

	void delete(int id);

	void edit(T t);
}
