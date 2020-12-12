package com.team.service;

import java.util.List;

import com.team.model.Transactions;

public interface TransactionService {
	void insert(Transactions transaction);

	void delete(int id);

	void edit(Transactions transaction);

	List<Transactions> getAll();

	Transactions get(int id);

}
