package com.example.btvn_week6.api;


import com.example.btvn_week6.dto.AccountDTO;
import com.example.btvn_week6.service.impl.AccountServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class AccountAPI {

    @Autowired
    private AccountServiceImpl accountService;

    @GetMapping("/{id}")
    public AccountDTO getUserById(@PathVariable("id") Long id) {
        return accountService.getAccountById(id);
    }

    @PostMapping
    public ResponseEntity<AccountDTO> createUser(@RequestBody AccountDTO accountDTO) {
        return accountService.createAccount(accountDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccountDTO> updateUser(@PathVariable("id") Long id, @RequestBody AccountDTO accountDTO) {
        return accountService.updateAccount(id, accountDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<AccountDTO> partialUpdateUser(@PathVariable("id") Long id, @RequestBody AccountDTO partialAccountDTO) {
        return accountService.partialUpdateAccount(id, partialAccountDTO);
    }

    @GetMapping("/search")
    public List<AccountDTO> searchUsers(@RequestParam(value = "email") String email) {
        return accountService.searchAccounts(email);
    }
}
