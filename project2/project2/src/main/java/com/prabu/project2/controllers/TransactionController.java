package com.prabu.project2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prabu.project2.Dto.TransactionDto;
import com.prabu.project2.entities.Transaction;
import com.prabu.project2.services.TransactionService;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
	@Autowired private TransactionService transactionService;
	
	@PostMapping("/play")
	public Transaction doTransaction(TransactionDto transaction) {
		return transactionService.playGame(transaction);
	}

}
