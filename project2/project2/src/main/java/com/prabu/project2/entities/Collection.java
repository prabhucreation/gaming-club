package com.prabu.project2.entities;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="collections")
public class Collection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDate date;
	private float amount;
	
	public Collection() {}
	public Collection(LocalDate date, float amount) {
		super();
		this.date = date;
		this.amount = amount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	
}
