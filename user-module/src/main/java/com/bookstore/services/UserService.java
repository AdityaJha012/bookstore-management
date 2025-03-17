package com.bookstore.services;

import com.bookstore.models.User;

public interface UserService 
{
	boolean isUserExist(String uid);
	void createAccount(User user);
	User getUser(String uid);
	void updateUser(User user);
	void updatePassword(String pass, String attribute);
}
