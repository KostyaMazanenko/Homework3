package com.gmail.kostamazanenko;

public class Human {

	private int age;
	private double height;
	private double weight;
	private String name;
	private String placeResidence;

	

	public Human(int age, double height, double weight, String name, String placeResidence) {
		super();
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.name = name;
		this.placeResidence = placeResidence;
	}

	public Human() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlaceResidence() {
		return placeResidence;
	}

	public void setPlaceResidence(String placeResidence) {
		this.placeResidence = placeResidence;
	}
	
	public String infoHuman() {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: " + this.name + System.lineSeparator());
		sb.append("Age: " + this.age + System.lineSeparator());
		sb.append("Height: " + this.height + System.lineSeparator());
		sb.append("Weight: " + this.weight + System.lineSeparator());
		sb.append("Place of residence: " + this.placeResidence + System.lineSeparator());
		return sb.toString();
	}
}
