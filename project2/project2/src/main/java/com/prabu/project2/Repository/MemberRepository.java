package com.prabu.project2.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prabu.project2.entities.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer> {
	Member findByPhone(String phone);

}
