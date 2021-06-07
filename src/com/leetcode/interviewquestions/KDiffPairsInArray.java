package com.leetcode.interviewquestions;

import java.util.Scanner;

public class KDiffPairsInArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		in.close();
	}

}
