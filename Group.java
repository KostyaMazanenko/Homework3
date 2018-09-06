package com.gmail.kostamazanenko;

public class Group {
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

	public void removeStudent(String name) {
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null && group[i].getName() == name) {
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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sortArray();
		for (int i = 0; i < group.length; i++) {
			if (group[i] != null) {
				sb.append(group[i].infoHuman() + System.lineSeparator());
			} else {
				sb.append("Empty" + System.lineSeparator());
			}
		}
		return sb.toString();
	}

}
