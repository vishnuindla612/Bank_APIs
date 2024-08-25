package com.vishnu.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank_info")
public class User {
	public User(String firstName, String lastName, Double balance) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.balance = balance;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	private String firstName;
	private String lastName;
	private Double balance;
}
