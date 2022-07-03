package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Account;
import com.example.demo.repositories.AccountRepo;

@RestController
public class AccountRestController {

	@Autowired
	AccountRepo accountrepo;
	
	@GetMapping("/accounts")
	public List<Account> getAccounts() {
		return accountrepo.findAll();
	}
	
	@PostMapping("/account")
	public void insertAccount(@RequestBody Account acc) {
		if (!accountrepo.existsById(acc.getAccountNo())) {
			accountrepo.save(acc);
		}
	}
	
	@PutMapping("/account/{accountNo}")
	public void updateAccount(@PathVariable int accountNo, @RequestBody Account acc) {
		if (accountrepo.existsById(accountNo)) {
			accountrepo.save(acc);
		}
	}
	
//	@DeleteMapping("/account/{accountNo}")
//	public void deactivateAccount(@PathVariable int accountNo) {
//		if (account.existsById(accountNo)) {
//			Account acc = account.findById(accountNo);
//			Account updatedAcc = acc;
//		}
//	}
	
	@GetMapping("/accounts/type/{accType}")
	public List<Account> getTypeAccount(@PathVariable String accType) {
		return accountrepo.findAllByAccType(accType);
	}
	
	@GetMapping("/accounts/status")
	public List<Account> getStatusAccount(int active) {
		return accountrepo.findAllByActive(active);
	}
	
	@GetMapping("/accounts/amount")
	public List<Account> getAmountAccount(int min, int max) {
		return accountrepo.findAllByAmountBetween(min, max);
	}
	
	@GetMapping("/accounts/bank")
	public List<Account> getBankNameAccount(String name) {
		return accountrepo.findAllByBankName(name);
	}
}
