package com.prabu.project2.entities;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;


@Entity
@Table(name="recharges")
public class Recharge {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private float amount;
	private LocalDateTime date_time;
	@JsonIgnore

	
	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member member;

	public Recharge() {}
	public Recharge(float amount, LocalDateTime date_time, Member member) {
		super();
		this.amount = amount;
		this.date_time = date_time;
		this.member = member ;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public LocalDateTime getDate_time() {
		return date_time;
	}

	public void setDate_time(LocalDateTime date_time) {
		this.date_time = date_time;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
	
	
}
