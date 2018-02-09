package com.ing.technicaltest.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    
    private String name;
    
    private BigDecimal amount;
    
    private Currency currency;
    
    @JsonIgnore
    @ManyToOne(optional=false)
    private User user;

    public Account() {}
    
	public Account( String name, BigDecimal amount, Currency currency, User user) {
		super();
		this.name = name;
		this.amount = amount;
		this.currency = currency;
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public Currency getCurrency() {
		return currency;
	}
	
	public String toString() {
		return String.format("Account[id=%d, name='%s', amount='%d', currency=%s]", id, name, amount, currency);
	}
}
