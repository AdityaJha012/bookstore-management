package com.book.store.service;

import com.book.store.model.User;
import jakarta.servlet.http.HttpSession;

public interface UserService {
    void registerUser(User user) throws Exception;

    boolean authenticateUser(User user, HttpSession session) throws Exception;
}
