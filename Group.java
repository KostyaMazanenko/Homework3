package com.gmail.kostamazanenko;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Group implements Voencomat {
	
	private Student[] group = new Student[10];
	private int number;

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student[] getGroup() {
		return group;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public void interactiveAddStudent() throws ExcessStudentException {
		if (isGroupFull()) {
			throw new ExcessStudentException();
		}

		int age = getAge();
		double height = getHeight();
		double weight = getWeight();
		String name = getName();
		String placeResidence = getPlaceResidence();
		int admissionDate = getAdmissionDate();
		String university = getUniversity();
		Group group = this;

		Student st = new Student(age, height, weight, name, placeResidence, admissionDate, university, group);
		addStudent(st);
	}

	public void addStudent(Student st) throws ExcessStudentException {
		if (isGroupFull()) {
			throw new ExcessStudentException();
		}

		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				group[i] = st;
				break;
			}
		}

		st.setGroup(this);
	}

	public boolean isGroupFull() {
		for (int i = 0; i < group.length; i++) {
			if (group[i] == null) {
				return false;
			}
		}
		return true;
	}

	public int getAge() {
		int age;
		for (;;) {
			try {
				age = Integer.valueOf(JOptionPane.showInputDialog("Input age of the student"));
				if (age <= 0) {
					throw new NegativeValueException();
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showInputDialog(null, "Wrong input");
			} catch (NegativeValueException e) {
				JOptionPane.showInputDialog(null, e.getMessage());
			}
		}
		return age;
	}

	public double getWeight() {
		double weight;
		for (;;) {
			try {
				weight = Double.valueOf(JOptionPane.showInputDialog("Input weight of the student"));
				if (weight <= 0) {
					throw new NegativeValueException();
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showInputDialog(null, "Wrong input");
			} catch (NegativeValueException e) {
				JOptionPane.showInputDialog(null, e.getMessage());
			}
		}
		return weight;
	}

	public double getHeight() {
		double height;
		for (;;) {
			try {
				height = Double.valueOf(JOptionPane.showInputDialog("Input height of the student"));
				if (height <= 0) {
					throw new NegativeValueException();
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showInputDialog(null, "Wrong input");
			} catch (NegativeValueException e) {
				JOptionPane.showInputDialog(null, e.getMessage());
			}
		}
		return height;
	}

	public String getName() {
		String name;
		for (;;) {
			try {
				name = String.valueOf(JOptionPane.showInputDialog("Input name of the student"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showInputDialog(null, "Wrong input");
			}
		}
		return name;
	}

	public String getUniversity() {
		String university;
		for (;;) {
			try {
				university = String.valueOf(JOptionPane.showInputDialog("Input univercity of the student"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showInputDialog(null, "Wrong input");
			}
		}
		return university;
	}

	public String getPlaceResidence() {
		String placeResidence;
		for (;;) {
			try {
				placeResidence = String
						.valueOf(JOptionPane.showInputDialog("Input place of the residence of the student"));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showInputDialog(null, "Wrong input");
			}
		}
		return placeResidence;
	}

	public int getAdmissionDate() {
		int admissionDate;
		for (;;) {
			try {
				admissionDate = Integer
						.valueOf(JOptionPane.showInputDialog("Input date of the admission of the student"));
				if (admissionDate <= 0) {
					throw new NegativeValueException();
				}
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showInputDialog(null, "Wrong input");
			} catch (NegativeValueException e) {
				JOptionPane.showInputDialog(null, e.getMessage());
			}
		}
		return admissionDate;
	}

	public void removeStudent(String name) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null && group[i].getName().equals(name)) {
				group[i] = null;
			}
		}
	}

	public void sortArray() {
		for (int i = 0; i < group.length - 1; i++) {
			for (int j = 0; j < group.length - i - 1; j++) {
				if (group[j] == null || group[j + 1] == null) {
					Student temp;
					temp = group[j];
					group[j] = group[j + 1];
					group[j + 1] = temp;
					continue;
				}
				if (group[j].getName().compareTo(group[j + 1].getName()) > 0) {
					Student temp;
					temp = group[j];
					group[j] = group[j + 1];
					group[j + 1] = temp;
				}
			}

		}
	}

	public void sortByCriterion() {
		Scanner sc = new Scanner(System.in);

		StringBuilder sb = new StringBuilder();
		sb.append("If you want to sort by age print 1" + System.lineSeparator());
		sb.append("If you want to sort by year of the admission print 2" + System.lineSeparator());
		sb.append("If you want to sort by height print 3" + System.lineSeparator());
		sb.append("If you want to sort by univercity print 4" + System.lineSeparator());
		sb.append("If you want to sort by name print 5" + System.lineSeparator());
		System.out.println(sb.toString());

		int i = sc.nextInt();
		
		System.out.println("If you want sort students in ascending order print 1");
		System.out.println("If you want sort students in descending order print 2");
		i = sc.nextInt();
		boolean revers;
		if(i == 1) {
			revers = true;
		} else {
			revers = false;
		}
		try {
			Arrays.sort(group, new ComparatorStudents(i, revers));
		} catch (InvalidParameterException e) {
			System.out.println("Wrong input" + System.lineSeparator() + "Input value must be from 1 to 5");
			System.out.println("Students wasnt sorted" + System.lineSeparator());
		}
	}
	
	public void sortByCriterion(int i, boolean revers) {
		try {
			Arrays.sort(group, new ComparatorStudents(i, revers));
		} catch (InvalidParameterException e) {
			System.out.println("Wrong input" + System.lineSeparator() + "Input value must be from 1 to 5");
			System.out.println("Students wasnt sorted" + System.lineSeparator());
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sortByCriterion();
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				sb.append(group[i].infoHuman() + System.lineSeparator());
			}
		}
		return sb.toString();
	}

	@Override
	public Student[] selection() {
		sortByCriterion(1, false);
		int j = 0;
		for (int i = 0; i < group.length; i++) {
			
			if(group[i] != null && group[i].getAge() >= 18) {
				j++;	
			}
		}
		
		Student[] st = Arrays.copyOf(group, j);
		
		return st;
	}

}
