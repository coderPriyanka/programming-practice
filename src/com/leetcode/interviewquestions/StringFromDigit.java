package com.leetcode.interviewquestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringFromDigit {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		List<String> result = findStrings(input);
		System.out.println("Number of Strings : " + result.size());
		for (String value : result) {
			System.out.print(value + " ");
		}
		System.out.println();
		in.close();
	}
	
	private static List<String> findStrings(String input) {
		List<String> result = new ArrayList<>();
		findStrings(input, 0, input.length() - 1, "", result);
		return result;
	}
	
	private static void findStrings(String input, int i, int j, String value, List<String> result) {
		if (i > j) {
			return;
		}
		String str = getString(input.charAt(i));
		if (i == j) {
			for (int k = 0; k < str.length(); k++) {
				result.add(value + str.charAt(k));
			}
			return;
		}
		for (int k = 0; k < str.length(); k++) {
			findStrings(input, i + 1, j, value + str.charAt(k), result);
		}
	}
	private static String getString(char ch) {
		if (ch == '2') {
			return "abc";
		}
		if (ch == '3') {
			return "def";
		}
		if (ch == '4') {
			return "ghi";
		}
		if (ch == '5') {
			return "jkl";
		}
		if (ch == '6') {
			return "mno";
		}
		if (ch == '7') {
			return "pqrs";
		}
		if (ch == '8') {
			return "tuv";
		}
		return "wxyz";
	}
}
