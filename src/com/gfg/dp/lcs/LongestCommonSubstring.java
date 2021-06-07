package com.gfg.dp.lcs;

import java.util.Scanner;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		System.out.println(longestCommonSubstring(s1, s2));
		in.close();
	}

	private static int longestCommonSubstring(String s1, String s2) {
		int[][] longestSubstring = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					longestSubstring[i][j] = 1 + longestSubstring[i - 1][j - 1];
				} else {
					longestSubstring[i][j] = 0;
				}
			}
		}
        int max = 0;
        for (int i = 0; i <= s1.length(); i++) {
            for (int j = 0; j <= s2.length(); j++) {
                max = Math.max(max, longestSubstring[i][j]);
            }
        }
        return max;
	}
}
