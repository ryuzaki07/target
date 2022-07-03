package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Account;

public interface AccountRepo extends JpaRepository<Account, Integer> {
	List<Account> findAllByAccType(String type);
	List<Account> findAllByActive(int active);
	List<Account> findAllByAmountBetween(int min, int max);
	List<Account> findAllByBankName(String name);
}
