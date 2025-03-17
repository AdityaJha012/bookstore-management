package com.bookstore.servicesImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.models.UserTransaction;
import com.bookstore.repositories.TransactionRepository;
import com.bookstore.services.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService
{
	@Autowired private TransactionRepository repository;

	@Override
	public void saveTransaction(UserTransaction transaction) 
	{
		repository.save(transaction);
	}

	@Override
	public List<UserTransaction> getList(String userid) 
	{
		return repository.findByUserid(userid);
	}
}
