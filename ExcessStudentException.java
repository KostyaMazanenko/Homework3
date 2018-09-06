package com.gmail.kostamazanenko;

public class ExcessStudentException extends Exception {

	@Override
	public String getMessage() {
		return "Group is alredy full";
	}

}
