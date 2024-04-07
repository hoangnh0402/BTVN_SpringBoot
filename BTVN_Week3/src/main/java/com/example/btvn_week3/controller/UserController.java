package com.example.btvn_week3.controller;

import com.example.btvn_week3.model.Store;
import com.example.btvn_week3.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    @GetMapping("/login")
    public String index() {
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("account") String account, @RequestParam("password") String password) {
        for (User user : Store.getUsers()) {
            if (account.equals(user.getUserName()) && password.equals(user.getPassWord()))
                return "redirect:/store";
        }
        return "alert";
    }

    @GetMapping("/store")
    public String about(Model model) {
        model.addAttribute("list", Store.getUsers());
        return "about";
    }

    @GetMapping("/user")
    @ResponseBody
    public List<User> getAllUser() {
        return Store.getUsers();
    }

    @GetMapping("/register")
    public String register() {
        return "signup";
    }

    @PostMapping("/register")
    public String register(User user) {
        Store.getUsers().add(user);
        return "redirect:/store";
    }
}
