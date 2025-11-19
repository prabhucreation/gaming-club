package com.prabu.project2.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabu.project2.entities.Member;
import com.prabu.project2.entities.Recharge;

@Repository
public interface RechargeRepository extends JpaRepository<Recharge,Integer>{
	List<Recharge> findByMember(Member member_id);

}
