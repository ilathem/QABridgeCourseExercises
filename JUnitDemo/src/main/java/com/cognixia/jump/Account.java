package com.cognixia.jump;

public class Account {

	private int balance;
	
	public Account(int i) {
		if (i < 0) {
			this.balance = 0;
		} else {
			this.balance = i;
		}
		
	}
	
	public int getBalance() {
		return this.balance;
	}
	
	public String deposit(int amount) {
		
		if (amount < 0) {
			return "Deposit Failed: Deposit Aamount bust be zero";
		}
		
		this.balance += amount;
		return "Deposit successful";
	}
	
	public String withdraw(int amount) throws OverdraftException {
		
		if (amount < 0) return "Deposit Failed: Deposit Withdraw bust be zero";
		
		if (amount > this.balance) throw new OverdraftException(amount, amount);
		
		this.balance -= amount;
		return "Deposit successful";
	}

}
