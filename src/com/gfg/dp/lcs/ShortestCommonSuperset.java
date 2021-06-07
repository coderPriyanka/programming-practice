package com.gfg.dp.lcs;

import java.util.Scanner;

public class ShortestCommonSuperset {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		System.out.println(findShortestSuperset(s1, s2));
		in.close();
	}

	private static int findShortestSuperset(String s1, String s2) {
		int[][] subsequence = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 1; i <= s1.length(); i++) {
			for (int j = 1; j <= s2.length(); j++) {
				if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					subsequence[i][j] = subsequence[i - 1][j - 1] + 1;
				} else {
					subsequence[i][j] = Math.max(subsequence[i - 1][j], subsequence[i][j - 1]);
				}
 			}
		}
		int subsequenceLength = subsequence[s1.length()][s2.length()];
		return s1.length() + s2.length() - subsequenceLength;
	}

}
