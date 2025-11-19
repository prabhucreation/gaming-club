package com.prabu.project2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabu.project2.entities.Member;
import com.prabu.project2.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
	List<Transaction> findByMember(Member member_id);

}
