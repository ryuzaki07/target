package com.example.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Account;
import com.example.demo.repositories.AccountRepo;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	AccountRepo accountrepo;
	
	@PostMapping("/transfer")
	public String transaction(@RequestBody int fromAcct, int toAcct, int amount, String ifsc) {
		if(accountrepo.existsById(fromAcct) && accountrepo.existsById(toAcct)){
			 Account acc= accountrepo.findById(toAcct).orElse(null);
			if(acc.getIfsc()==ifsc)
			{
				
			}
			int amont =acc.getAmount();
			//else
				return "The ifsc code and the account number do not match";
			
			
		
			return "Hi";
		} else {
			return "Sorry, this is  invalid transaction.";
		}
	}
}
