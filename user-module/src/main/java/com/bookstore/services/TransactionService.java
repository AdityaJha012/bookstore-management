package com.bookstore.services;

import java.util.List;

import com.bookstore.models.UserTransaction;

public interface TransactionService
{
	void saveTransaction(UserTransaction transaction);
	List<UserTransaction> getList(String attribute);
}
