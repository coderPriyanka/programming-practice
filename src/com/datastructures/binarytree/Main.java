package com.datastructures.binarytree;

import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Student> students = Arrays.asList(
				new Student("Quadros", 10),
				new Student("Priyanka", 10),
				new Student("Alice", 2), 
				new Student("Bob", 12), 
				new Student("Anna", 25));
		
		students.sort((s1, s2) -> {
			if (s1.getId() == s2.getId()) {
				return s1.getName().compareTo(s2.getName());
			}
			return s1.getId() < s2.getId() ? -1 : 1;
		});
		students.forEach(student -> System.out.println(student.getId() + ", " + student.getName()));
	}
}
