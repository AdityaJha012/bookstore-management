package com.book.store.controller;

import com.book.store.model.User;
import com.book.store.service.UserService;
import com.book.store.util.AESUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;

@Controller
@RequestMapping("bookstore/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login-user")
    private String authenticateUser(@ModelAttribute User user, RedirectAttributes redirectAttributes, HttpSession session) {
        try {
            boolean loginStatus = this.userService.authenticateUser(user, session);

            if (loginStatus) {
                redirectAttributes.addFlashAttribute("successMessage", "User Logged in Successfully!");
                return "redirect:/bookstore/user/dashboard";
            } else {
                redirectAttributes.addFlashAttribute("failureMessage", "Invalid Username or Password!");
                return "redirect:/bookstore/user/login";
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error during user login: " + e.getMessage());
            return "redirect:/bookstore/user/login";
        }
    }

    @PostMapping("register-user")
    private String registerUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        try {
            this.userService.registerUser(user);
            redirectAttributes.addFlashAttribute("successMessage", "User Registered Successfully! You can log in now.");
            return "redirect:/bookstore/user/login";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("errorMessage", "Error during user registration: " + e.getMessage());
            return "redirect:/bookstore/user/register";
        }
    }

    @GetMapping("profile")
    private String getUserDetailsProfilePage(
        Model model,
        HttpSession session
    ) {
        Long userId = (Long) session.getAttribute("userId");

        if (userId == null) {
            return "redirect:/bookstore/user/login";
        }

        User user = this.userService.getUserByUserId(userId);

        if (user == null) {
            return "redirect:/bookstore/user/login";
        }

        session.setAttribute("user", user);

        model.addAttribute("user", user);
        return "user/profile";
    }

    @GetMapping("edit-details")
    private String getUserDetailsEditPage(
            Model model,
            HttpSession session
    ) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/bookstore/user/login";
        }

        model.addAttribute("user", user);

        return "user/edit-details";
    }

    @PostMapping("update-details")
    private String updateUserDetails(
        User user,
        Model model,
        HttpSession session
    ) {
        User savedUser = (User) session.getAttribute("user");

        if (savedUser == null) {
            return "redirect:/bookstore/user/login";
        }

        user.setValidFlag(savedUser.getValidFlag());
        user.setCreatedBy(savedUser.getCreatedBy());
        user.setCreatedAt(savedUser.getCreatedAt());
        user.setUpdatedBy(user.getCreatedBy());
        user.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        this.userService.updateUserDetails(user);
        session.setAttribute("fullName", user.getFullName());
        model.addAttribute("successMessage", "User details updated successfully!");

        return "user/edit-details";
    }

    @GetMapping("change-password")
    private String getChangePasswordPage(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/bookstore/user/login";
        }

        model.addAttribute("user", user);
        return "user/change-password";
    }

    @PostMapping("update-password")
    private String updateUserPassword(
        @RequestParam Long userId,
        @RequestParam String currentPassword,
        @RequestParam String newPassword,
        @RequestParam String confirmPassword,
        HttpSession session,
        Model model
    ) {
        User user = (User) session.getAttribute("user");

        if (user == null) {
            return "redirect:/bookstore/user/login";
        }

        try {
            // Check if current password matches
            if (!AESUtil.encrypt(currentPassword).equals(user.getPassword())) {
                model.addAttribute("errorMessage", "Current password is incorrect!");
                model.addAttribute("user", user);
                return "user/change-password";
            }

            // Check if new password and confirm password match
            if (!newPassword.equals(confirmPassword)) {
                model.addAttribute("errorMessage", "New passwords do not match!");
                model.addAttribute("user", user);
                return "user/change-password";
            }

            // Update the password
            user.setPassword(AESUtil.encrypt(newPassword));
            this.userService.updateUserDetails(user);

            // Add success message
            model.addAttribute("successMessage", "Password updated successfully!");
            model.addAttribute("user", user);

            return "user/change-password";
        } catch (Exception e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("user", user);

            return "user/change-password";
        }
    }
}
