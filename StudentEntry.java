package com.heena.ec.student;

import java.util.Scanner;

class StudentEntry {
	String name;
	String stu_id;
	int score;
	public StudentEntry() {
		this(" ", " ", 0);
	}
	public StudentEntry(String initName, String initId, int initScore) {
		name = initName;
		stu_id = initId;
		score = initScore;
	}
}

public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Input number of students:");
		int n = Integer.parseInt(in.nextLine().trim());
		System.out.println("Input Student Name, ID, Score:");
		StudentEntry stu = new StudentEntry();
		StudentEntry max = new StudentEntry();
		StudentEntry min = new StudentEntry(" ", " ", 100);
		for (int i = 0; i < n; i ++) {
			stu.name = in.next();
			stu.stu_id = in.next();
			stu.score = in.nextInt();
			if (max.score < stu.score) {
				max.name = stu.name;
				max.stu_id = stu.stu_id;
				max.score = stu.score;
			}
			if (min.score > stu.score) {
				min.name = stu.name;
				min.stu_id = stu.stu_id;
				min.score = stu.score;
			}
		}
		System.out.println("name, ID of the highest score and the lowest score:");
		System.out.println(max.name + " " + max.stu_id);
		System.out.println(min.name + " " + min.stu_id);
		in.close();
	}
}

