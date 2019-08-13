package com.ba.exep;

public class UserValidationException extends Exception{

	String s1;

	public UserValidationException(String s) {
		s1 = s;

	}

	public String toString() {
		return (s1);
	}

	
}
