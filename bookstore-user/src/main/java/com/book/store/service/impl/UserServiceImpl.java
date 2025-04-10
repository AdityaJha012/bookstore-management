package com.book.store.service.impl;

import com.book.store.model.User;
import com.book.store.repository.UserRepository;
import com.book.store.service.UserService;
import com.book.store.util.AESUtil;
import jakarta.servlet.http.HttpSession;
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
    public boolean authenticateUser(User user, HttpSession session) throws Exception {
        Optional<User> userOpt = userRepository.findByUserName(user.getUserName());

        if (userOpt.isPresent()) {
            final User savedUser = userOpt.get();

            String decryptedPassword = AESUtil.decrypt(savedUser.getPassword());
            boolean passwordCheck = decryptedPassword.equals(user.getPassword());

            if (passwordCheck) {
                session.setAttribute("userId", savedUser.getId());
                session.setAttribute("userName", savedUser.getUserName());
                session.setAttribute("fullName", savedUser.getFullName());

                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public User getUserByUserId(Long userId) {
        return this.userRepository.findById(userId).orElse(null);
    }

    @Override
    public void updateUserDetails(User user) {
        this.userRepository.save(user);
    }
}
