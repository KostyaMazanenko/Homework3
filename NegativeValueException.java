package com.gmail.kostamazanenko;

public class NegativeValueException extends Exception {

	@Override
	public String getMessage() {
		return "Value must be positive";
	}
	
	
}