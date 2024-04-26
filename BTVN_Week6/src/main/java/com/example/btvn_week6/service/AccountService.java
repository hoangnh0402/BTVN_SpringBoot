package com.example.btvn_week6.service;

import com.example.btvn_week6.dto.AccountDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AccountService {
    AccountDTO getAccountById(Long id);
    AccountDTO findById(Long id);
    ResponseEntity<AccountDTO> createAccount(AccountDTO accountDTO);
    ResponseEntity<AccountDTO> updateAccount(Long id, AccountDTO accountDTO);
    ResponseEntity<AccountDTO> partialUpdateAccount(Long id, AccountDTO accountDTO);
    List<AccountDTO> searchAccounts(String email);
    List<AccountDTO> findAll();
    void deleteAccount(Long id);
}
