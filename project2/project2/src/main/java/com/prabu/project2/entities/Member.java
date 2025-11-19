package com.prabu.project2.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name="members")
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private String name;
	private float balance = 0 ;
	private String phone;
	@JsonIgnore

	
	@OneToMany(mappedBy = "member")
	private List<Recharge> recharges;
	public Member() {}
	public Member(String name, float balance, String phone) {
		super();
		this.name = name;
		this.balance = balance;
		this.phone = phone;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public float getFees() {
		return 0;
	}
	
	
}
