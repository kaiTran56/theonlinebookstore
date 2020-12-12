package com.team.service.impl;

import java.util.List;

import com.team.dao.TransactionDao;
import com.team.dao.impl.TransactionDaoImpl;
import com.team.model.Transactions;
import com.team.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {

	private TransactionDao<Transactions> transactionDao = new TransactionDaoImpl();

	@Override
	public void insert(Transactions transaction) {
		transactionDao.insert(transaction);
	}

	@Override
	public void delete(int id) {
		transactionDao.delete(id);

	}

	@Override
	public void edit(Transactions transaction) {
		transactionDao.edit(transaction);

	}

	@Override
	public List<Transactions> getAll() {
		// TODO Auto-generated method stub
		return transactionDao.getAll();
	}

	@Override
	public Transactions get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
