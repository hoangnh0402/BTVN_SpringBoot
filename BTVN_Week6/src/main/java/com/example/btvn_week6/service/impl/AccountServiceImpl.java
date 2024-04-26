package com.example.btvn_week6.service.impl;

import com.example.btvn_week6.converter.AccountConverter;
import com.example.btvn_week6.dto.AccountDTO;
import com.example.btvn_week6.entity.AccountEntity;
import com.example.btvn_week6.exception.AlreadyExistsException;
import com.example.btvn_week6.exception.NotFoundException;
import com.example.btvn_week6.repository.AccountRepository;
import com.example.btvn_week6.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountConverter accountConverter;

    @Override
    public AccountDTO getAccountById(Long id) {
        Optional<AccountEntity> userOptional = accountRepository.findById(id);
        if (userOptional.isPresent()) {
            AccountDTO userDTO = accountConverter.convertToDto(userOptional.get());
            return userDTO;
        } else {
            throw new NotFoundException("UserEntity not found with id " + id , HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public AccountDTO findById(Long id) {
        return accountConverter.convertToDto(accountRepository.findById(id).get());
    }

    @Override
    public ResponseEntity<AccountDTO> createAccount(AccountDTO userDTO) {
        AccountEntity userEntity = accountConverter.convertToEntity(userDTO);
        if (accountRepository.findAccountByUserName(userEntity.getUserName()) != null) {
            throw new AlreadyExistsException("UserEntity already exists with username " + userEntity.getUserName(), HttpStatus.ALREADY_REPORTED);
        }
        AccountEntity createdUserEntity = accountRepository.save(userEntity);
        AccountDTO createUserDTO = accountConverter.convertToDto(createdUserEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(createUserDTO);
    }

    @Override
    public ResponseEntity<AccountDTO> updateAccount(Long id, AccountDTO userDTO) {
        Optional<AccountEntity> userOptional = accountRepository.findById(id);
        if (userOptional.isPresent()) {
            AccountEntity existingUserEntity = userOptional.get();
            existingUserEntity = accountConverter.convertToEntity(userDTO);
            AccountEntity userEntity = accountRepository.save(existingUserEntity);
            AccountDTO updateUserDTO = accountConverter.convertToDto(userEntity);
            return ResponseEntity.ok(updateUserDTO);
        } else {
            throw new NotFoundException("UserEntity not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<AccountDTO> partialUpdateAccount(Long id, AccountDTO partialUserDTO) {
        Optional<AccountEntity> userOptional = accountRepository.findById(id);
        if (userOptional.isPresent()) {
            AccountEntity existingUserEntity = userOptional.get();
            if (partialUserDTO.getUserName() != null) {
                existingUserEntity.setUserName(partialUserDTO.getUserName());
            }
            if (partialUserDTO.getEmail() != null) {
                existingUserEntity.setEmail(partialUserDTO.getEmail());
            }
            if (partialUserDTO.getPassWord() != null) {
                existingUserEntity.setPassWord(partialUserDTO.getPassWord());
            }
            AccountEntity userEntity = accountRepository.save(existingUserEntity);
            AccountDTO updateUserDTO = accountConverter.convertToDto(userEntity);
            return ResponseEntity.ok(updateUserDTO);
        } else {
            throw new NotFoundException("UserEntity not found with id " + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<AccountDTO> searchAccounts(String email) {
        List<AccountEntity> userEntities = accountRepository.findByEmailContaining(email);
        List<AccountDTO> userDTOS = new ArrayList<>();
        for(AccountEntity item : userEntities){
            AccountDTO userDTO = accountConverter.convertToDto(item);
            userDTOS.add(userDTO);
        }
        return userDTOS;
    }

    @Override
    public List<AccountDTO> findAll() {
        List<AccountEntity> userEntities = accountRepository.findAll();
        List<AccountDTO> userDTOS = accountConverter.convertToListDto(userEntities);
        return userDTOS;
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }
}
