package com.gfg.dp.lcs;

import java.util.Scanner;

public class LongestPalindromicSubsequence {

	private static int[][] palindromicSubstring;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		initialiseDPArray();
		System.out.println(longestPalindromicSubstring(input, 0, input.length() - 1));
		System.out.println(longestPalindromicSubstringUsingMemozation(input, 0, input.length() - 1));
		System.out.println(longestPalindromicSubstringUsingDP(input));
		in.close();
	}

	private static void initialiseDPArray() {
		palindromicSubstring = new int[1001][1001];
		for (int i = 0; i <= 1000; i++) {
			for (int j = 1; j <= 1000; j++) {
				palindromicSubstring[i][j] = -1;
			}
		}
	}

	private static int longestPalindromicSubstring(String input, int i, int j) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return 1;
		}
		if (input.charAt(i) == input.charAt(j)) {
			return 2 + longestPalindromicSubstring(input, i + 1, j - 1);
		}
		return Math.max(longestPalindromicSubstring(input, i + 1, j), longestPalindromicSubstring(input, i, j - 1));
	}

	private static int longestPalindromicSubstringUsingMemozation(String input, int i, int j) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return 1;
		}
		if (palindromicSubstring[i][j] != -1) {
			return palindromicSubstring[i][j];
		}
		if (input.charAt(i) == input.charAt(j)) {
			palindromicSubstring[i][j] = 2 + longestPalindromicSubstring(input, i + 1, j - 1);
		} else {
			palindromicSubstring[i][j] = Math.max(longestPalindromicSubstring(input, i + 1, j), longestPalindromicSubstring(input, i, j - 1));
		}
		return palindromicSubstring[i][j];
	}
	
	private static int longestPalindromicSubstringUsingDP(String input) {
		
		// LPS (input) = LCS (input, rev(input))
		int[][] substring = new int[input.length() + 1][input.length() + 1];
//		for (int i = 1; i <= input.length(); i++) {
//			for (int j = i; j <= input.length(); j++) {
//				if (i == j) {
//					substring[i][j] = 1;
//				}
//				else if (input.charAt(i - 1) == input.charAt(j - 1)) {
//					substring[i][j] = 1 + substring[i - 1][j - 1];
//				}
//				else {
//					substring[i][j] = Math.max(substring[i - 1][j], substring[i][j - 1]);
//				}
//			}
//		}
		return substring[input.length()][input.length()];
	}
}
