package com.prabu.project2.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prabu.project2.Dto.TransactionDto;
import com.prabu.project2.Repository.GameRepository;
import com.prabu.project2.Repository.MemberRepository;
import com.prabu.project2.Repository.TransactionRepository;
import com.prabu.project2.entities.Game;
import com.prabu.project2.entities.Member;
import com.prabu.project2.entities.Transaction;

@Service
public class TransactionService {
	@Autowired TransactionRepository transactionRepo;
	@Autowired MemberRepository memberRepo;
	@Autowired GameRepository gameRepo;
	
	public Transaction playGame(TransactionDto transactionDto) {
		Member member = memberRepo.findById(transactionDto.getMember_id()).get();
		Game game = gameRepo.findById(transactionDto.getMember_id()).get();
		
		Transaction transaction = new Transaction();
		transaction.setGame(game);
		transaction.setDate_time(LocalDateTime.now());
		transaction.setMember(member);
		transactionRepo.save(transaction);
		
		member.setBalance(member.getBalance() - game.getAmount());
		memberRepo.save(member);
		
		return transaction;


	}
}
