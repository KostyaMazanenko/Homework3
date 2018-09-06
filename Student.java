package com.gmail.kostamazanenko;

public class Student extends Human {
	private int admissionDate;
	private String university;
	private Group group;
	
	public Student(int age, double height, double weight, String name, String placeResidence, int admissionDate,
			String university, Group group) {
		super(age, height, weight, name, placeResidence);
		this.admissionDate = admissionDate;
		this.university = university;
		this.group = group;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(int admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public String infoHuman() {
		StringBuilder sb = new StringBuilder();
		sb.append("University: " + this.university + System.lineSeparator());
		sb.append("Year of the admission to the university: " + this.admissionDate + System.lineSeparator());
		sb.append("Group: " + this.group.getNumber() + System.lineSeparator());
		return super.infoHuman() + sb.toString();
	}
	
	
}
