package com.gfg.dp.lcs;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LongestCommonSubsequence {
	
	private static int[][] dp;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		initialiseDPArrray();
		System.out.println(longestSubsequenceRecursive(s1, s1.length() - 1, s2, s2.length() - 1));
		System.out.println(longestSubsequenceRecursiveWithMemoization(s1, s1.length() - 1, s2, s2.length() - 1));
		Deque<Character> sequence = longestSubsequenceWithDynamicProgramming(s1, s2);
		System.out.println(sequence.size());
		while (!sequence.isEmpty()) {
			System.out.print(sequence.removeFirst() + " ");
		}
		in.close();
	}

	private static void initialiseDPArrray() {
		dp = new int[1001][1001];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j <= 1000; j++) {
				dp[i][j] = -1;
			}
		}
	}
	
	private static int longestSubsequenceRecursive(String s1, int index1, String s2, int index2) {
		if (index1 < 0 || index2 < 0) {
			return 0;
		}
		if (s1.charAt(index1) == s2.charAt(index2)) {
			return 1 + longestSubsequenceRecursive(s1,  index1 - 1, s2, index2 - 1);
		}
		return Math.max(longestSubsequenceRecursive(s1,  index1 - 1, s2, index2), 
				longestSubsequenceRecursive(s1,  index1, s2, index2 - 1));
	}
	
	private static int longestSubsequenceRecursiveWithMemoization(String s1, int index1, String s2, int index2) {
		if (index1 < 0 || index2 < 0) {
			return 0;
		}
		if (dp[index1][index2] != -1) {
			return dp[index1][index2];
		}
		if (s1.charAt(index1) == s2.charAt(index2)) {
			dp[index1][index2] = 1 + longestSubsequenceRecursive(s1, index1 - 1, s2, index2 - 1);
		} else {
			dp[index1][index2] = Math.max(longestSubsequenceRecursive(s1,  index1 - 1, s2, index2), 
				longestSubsequenceRecursive(s1,  index1, s2, index2 - 1));
		}
		return dp[index1][index2];
	}
	
	private static Deque<Character> longestSubsequenceWithDynamicProgramming(String s1, String s2) {
		int[][] longestSubsequence = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					longestSubsequence[i][j] = 1 + longestSubsequence[i - 1][j - 1];
				} else {
					longestSubsequence[i][j] = Math.max(longestSubsequence[i - 1][j], longestSubsequence[i][j - 1]);
				}
			}
		}
		Deque<Character> sequence = getLongestCommonSubsequence(longestSubsequence, s1, s2);
		return sequence;
	}

	private static Deque<Character> getLongestCommonSubsequence(int[][] longestSubsequence, String s1, String s2) {
		Deque<Character> sequence = new LinkedList<>();
		int index1 = s1.length(), index2 = s2.length();
		while (index1 > 0 && index2 > 0) {
			if (s1.charAt(index1 - 1) == s2.charAt(index2 - 1)) {
				sequence.addFirst(s1.charAt(index1 - 1));
				index1--;
				index2--;
			} else if (longestSubsequence[index1][index2] == longestSubsequence[index1 - 1][index2]) {
				index1--;
			} else {
				index2--;
			}
		}
		
		return sequence;
	}

}




