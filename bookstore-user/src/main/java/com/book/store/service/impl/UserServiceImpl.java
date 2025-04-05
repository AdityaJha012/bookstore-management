package com.book.store.service.impl;

import com.book.store.model.User;
import com.book.store.repository.UserRepository;
import com.book.store.service.UserService;
import com.book.store.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public void registerUser(User user) throws Exception {
        String encryptedPassword = AESUtil.encrypt(user.getPassword());
        user.setPassword(encryptedPassword);

        user.setValidFlag('Y');
        user.setCreatedBy("Admin");
        user.setCreatedAt(new Timestamp(System.currentTimeMillis()));

        this.userRepository.save(user);
    }

    @Override
    public boolean authenticateUser(User user) throws Exception {
        Optional<User> userOpt = userRepository.findByUserName(user.getUserName());
        if (userOpt.isPresent()) {
            String decryptedPassword = AESUtil.decrypt(userOpt.get().getPassword());
            return decryptedPassword.equals(user.getPassword());
        }
        return false;
    }
}
