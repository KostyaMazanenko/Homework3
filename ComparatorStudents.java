package com.gmail.kostamazanenko;

import java.security.InvalidParameterException;
import java.util.Comparator;

public class ComparatorStudents implements Comparator {
	int criterion;
	boolean revers;
	
	public ComparatorStudents(int criterion, boolean revers) {
		super();
		this.criterion = criterion;
		this.revers = revers;
	}

	public ComparatorStudents() {
		super();
		
	}

	@Override
	public int compare(Object one, Object two) throws InvalidParameterException {
		int rev = 1;
		
		if(!revers) {
			rev = -1;
		}
		
		if( one == null && two == null) {
			return 0;
		}
		
		if( one == null ) {
			return 1;
		}
		
		if ( two == null) {
			return -1;
		}
		
		Student stOne = (Student) one;
		Student stTwo = (Student) two;
		
		
		if(criterion == 1) {
			return (stOne.getAge() - stTwo.getAge()) * rev;
		}
		
		if(criterion == 2) {
			return (stOne.getAdmissionDate() - stTwo.getAdmissionDate()) * rev;
		}
		
		if(criterion == 3) {
			if (stOne.getHeight() > stTwo.getHeight()) {
				return 1 * rev;
			}
			
			if (stOne.getHeight() < stTwo.getHeight()) {
				return -1 * rev;
			}
			
			return 0;
		}
		
		if(criterion == 4) {
			return stOne.getUniversity().compareTo(stTwo.getUniversity()) * rev;
		}

		if(criterion == 5) {
			return stOne.getName().compareTo(stTwo.getName()) * rev;
		}

		throw new InvalidParameterException();
	}
	
	
}
