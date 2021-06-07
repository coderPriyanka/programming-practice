package com.gfg.dp.lcs;

import java.util.Scanner;

public class MinimumDeletionsToMakePalindrome {
	
	private static int[][] dp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String input = in.nextLine();
		initialiseDPArray(input);
		// input.length - LPS(input)
		System.out.println(input.length() - longestPalindromicSubsequence(input, 0, input.length() - 1));
		in.close();
	}

	private static void initialiseDPArray(String input) {
		dp = new int[input.length() + 1][input.length() + 1];
		for (int i = 0; i < input.length(); i++) {
			for (int j = 0; j <= input.length(); j++) {
				dp[i][j] = -1;
			}
		}
	}

	private static int longestPalindromicSubsequence(String input, int i, int j) {
		if (i > j) {
			return 0;
		}
		if (i == j) {
			return 1;
		}
		if (dp[i][j] != -1) {
			return dp[i][j];
		}
		if (input.charAt(i) == input.charAt(j)) {
			dp[i][j] = 2 + longestPalindromicSubsequence(input, i + 1, j - 1);
		} else {
			dp[i][j] = Math.max(longestPalindromicSubsequence(input, i + 1, j), longestPalindromicSubsequence(input, i, j - 1));
		}
		return dp[i][j];
	}

}
