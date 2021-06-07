package com.gfg.dp.lcs;

import java.util.Scanner;

public class MinOperationsToConvertString {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		System.out.println(minimumOperations(s1, s2));
		in.close();
	}

	private static int minimumOperations(String s1, String s2) {
		int[][] subsequence = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i <= s1.length(); i++) {
			subsequence[i][0] = 0;
		}
		for (int j = 0; j <= s2.length(); j++) {
			subsequence[0][j] = 0;
		}
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
		int insertions = s2.length() - subsequenceLength;
		int deletions = s1.length() - subsequenceLength;
		System.out.println("Number of insertions : " + insertions);
		System.out.println("Number of deletions : " + deletions);
		return insertions + deletions;
	}

}
