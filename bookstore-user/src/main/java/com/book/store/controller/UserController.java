package com.book.store.controller;

import com.book.store.model.User;
import com.book.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("bookstore/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("login-user")
    private String authenticateUser(@ModelAttribute User user, RedirectAttributes redirectAttributes) {
        try {
            boolean loginStatus = this.userService.authenticateUser(user);

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
}
