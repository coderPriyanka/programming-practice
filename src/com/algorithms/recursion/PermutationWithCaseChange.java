package com.algorithms.recursion;

import java.util.Scanner;

public class PermutationWithCaseChange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		findPermutations(input);
		in.close();
	}
	
	private static void findPermutations(String input) {
		findPermutations(input, "");
	}
	
	private static void findPermutations(String input, String output) {
		if (input.length() == 0) {
			System.out.print(output + " ");
			return;
		}
		String output1 = output + input.substring(0, 1).toUpperCase();
		String output2 = output + input.substring(0, 1);
		input = input.substring(1);
		findPermutations(input, output1);
		findPermutations(input, output2);
	}
}
