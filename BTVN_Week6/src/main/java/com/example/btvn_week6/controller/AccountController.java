package com.example.btvn_week6.controller;


import com.example.btvn_week6.dto.AccountDTO;
import com.example.btvn_week6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/login")
    public String index() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        List<AccountDTO> accountDTOS = accountService.findAll();
        if(username == null || username.trim().isEmpty()){
            return "alertAccount";
        }
        else if(password == null || password.trim().isEmpty()){
            return "alertPassWord";
        }
        for(AccountDTO account : accountDTOS){
            if (username.equals(account.getUserName()) && password.equals(account.getPassWord()))
                return "redirect:/store";
        }
        return "alert";
    }


    @GetMapping("/store")
    public String about(Model model) {
        model.addAttribute("list", accountService.findAll());
        return "about";
    }

    @GetMapping("/account")
    @ResponseBody
    public List<AccountDTO> getAllUser(){
        return accountService.findAll();
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(AccountDTO account){
        accountService.createAccount(account);
        return "redirect:/store";
    }

    @PostMapping("/account_delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
        return "redirect:/store";
    }

    @GetMapping("/account_put/{id}")
    public String putUser(@PathVariable("id") Long id, Model model){
        model.addAttribute("list", accountService.findById(id));
        return "update";
    }

    @PostMapping("/account_put")
    public String putUser(@ModelAttribute("list") AccountDTO accountDTO) {
        accountService.updateAccount(accountDTO.getId(), accountDTO);
        return "redirect:/store";
    }
}
