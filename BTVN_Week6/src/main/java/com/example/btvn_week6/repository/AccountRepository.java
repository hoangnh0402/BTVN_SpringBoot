package com.example.btvn_week6.repository;

import com.example.btvn_week6.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    AccountEntity findAccountByUserName(String username);
    List<AccountEntity> findByEmailContaining(String email);
}
