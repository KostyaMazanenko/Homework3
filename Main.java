package com.gmail.kostamazanenko;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {		
		Group gr = new Group();
		
		gr.setNumber(1);
		
		Student st = new Student(14, 180, 70, "Sasha", "Revutsgovo street", 2015, "KPI", gr);
		Student st1 = new Student(23, 180, 70, "Kostya", "Revut street", 2015, "KPI", gr);
		Student st2 = new Student(20, 180, 70, "Vadim", "Borshchovo street", 2015, "KPI", gr);
		Student st3 = new Student(28, 180, 70, "Anton", "Teatr street", 2015, "KPI", gr);
		Student st4 = new Student(23, 180, 70, "Igor", "RLeva street", 2015, "KPI", gr);
		Student st5 = new Student(12, 180, 70, "Valera", "Way street", 2015, "KPI", gr);
		Student st6 = new Student(87, 180, 70, "Nika", "New street", 2015, "KPI", gr);
		Student st7 = new Student(2, 180, 70, "Timur", "Mac street", 2015, "KPI", gr);
		Student st8 = new Student(12, 180, 70, "Olesya", "Neo street", 2015, "KPI", gr);
		Student st9= new Student(11, 180, 70, "Valentin", "Isla street", 2015, "KPI", gr);
		Student st10 = new Student(12, 180, 70, "Ira", "Mi street", 2015, "KPI", gr);

		try {
			gr.addStudent(st);
			gr.addStudent(st1);
			gr.addStudent(st2);
			gr.addStudent(st3);
			gr.addStudent(st4);
			gr.addStudent(st5);
			gr.addStudent(st6);
			gr.addStudent(st7);
			gr.addStudent(st8);
			gr.interactiveAddStudent();
			gr.interactiveAddStudent();
		} catch (ExcessStudentException e) {
			System.out.println(e.getMessage());
		}
		
		gr.removeStudent("Sasha");
		gr.removeStudent("Kostya");
		
		Student[] stu = gr.selection();
		
		for (int i = 0; i < stu.length; i++) {
			System.out.println(stu[i].infoHuman());
		}
	    
	}
	
}
