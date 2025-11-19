package com.prabu.project2.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prabu.project2.Dto.MembershipDto;
import com.prabu.project2.Repository.CollectionRepository;
import com.prabu.project2.Repository.MemberRepository;
import com.prabu.project2.Repository.RechargeRepository;
import com.prabu.project2.Repository.TransactionRepository;
import com.prabu.project2.entities.Collection;
import com.prabu.project2.entities.Member;
import com.prabu.project2.entities.Recharge;
import com.prabu.project2.entities.Transaction;

@Service
public class MemberService {
	
	@Autowired private MemberRepository memberRepo;
	@Autowired private RechargeRepository rechargeRepo;
	@Autowired private CollectionRepository collectionRepo;
	@Autowired private TransactionRepository transactionRepo;
	
	public Member createMembership(MembershipDto memberDto) {
		Member member = new Member();
		member.setName(memberDto.getName());
		member.setPhone(memberDto.getPhone());
		member.setBalance(member.getFees());
		memberRepo.save(member);
		
		Recharge recharge = new Recharge();
		recharge.setAmount(memberDto.getFees());
		recharge.setDate_time(LocalDateTime.now());
		recharge.setMember(member);
		rechargeRepo.save(recharge);
		
		Optional<Collection> optional = collectionRepo.findByDate(LocalDate.now());
		if(optional.isPresent()) {
			Collection collection = optional.get();
			collection.setDate(LocalDate.now());
			collection.setAmount(collection.getAmount()+ memberDto.getFees());
			collectionRepo.save(collection);
		}else {
			Collection collection = new Collection();
			collection.setDate(LocalDate.now());
			collection.setAmount(memberDto.getFees());
			collectionRepo.save(collection);
		}
		return member;
	}
	public List<Member> getMembers(){
		return memberRepo.findAll();
	}
	public Map<String, Object> searchMember(String phone){
		Member member =  memberRepo.findByPhone(phone);
		List<Transaction> transaction = transactionRepo.findByMember(member);
		List<Recharge> recharge = rechargeRepo.findByMember(member);
		
		Map<String,Object> response = new HashMap<String, Object>();
		
		response.put("member", member);
		response.put("recharge_history", recharge);
		response.put("transaction_history",transaction);
		return response;
	}
	
	
}
