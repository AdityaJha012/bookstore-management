package com.bookstore.servicesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bookstore.models.User;
import com.bookstore.repositories.UserRepository;
import com.bookstore.services.UserService;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository repository;

	@Override
	public boolean isUserExist(String uid) 
	{
		return repository.existsById(uid);
	}

	@Override
	public void createAccount(User user) 
	{
		repository.save(user);
	}

	@Override
	public User getUser(String uid) 
	{
		User us = repository.findById(uid).orElse(null);
		return us;
	}

	@Override
	public void updateUser(User user) 
	{
		repository.save(user);
	}

	@Override
	public void updatePassword(String pass, String uid) 
	{
		repository.updatePassword(pass, uid);
	}
}
