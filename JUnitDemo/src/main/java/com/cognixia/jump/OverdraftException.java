package com.cognixia.jump;

public class OverdraftException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public OverdraftException(int amount, int balance) {
		super("Cannot withdraw " + amount + ", account only has " + balance);
	}

}
