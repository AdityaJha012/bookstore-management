package com.book.store.service;

import com.book.store.model.User;

public interface UserService {
    void registerUser(User user) throws Exception;

    boolean authenticateUser(User user) throws Exception;
}
