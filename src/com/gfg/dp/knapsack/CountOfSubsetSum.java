package com.gfg.dp.knapsack;

import java.util.Scanner;

public class CountOfSubsetSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		int sum = in.nextInt();
		System.out.println(countSubsetSum(input, sum));
		in.close();
	}

	private static int countSubsetSum(int[] input, int sum) {
		int[][] subsetCount = new int[input.length + 1][sum + 1];
		for (int j = 0; j <= sum; j++) {
			subsetCount[0][j] = 0;
		}
		for (int i = 0; i <= input.length; i++) {
			subsetCount[i][0] = 1;
		}
		for (int i = 1; i <= input.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (input[i - 1] > j) {
					subsetCount[i][j] = subsetCount[i - 1][j];
				} else {
					subsetCount[i][j] = subsetCount[i - 1][j] + subsetCount[i - 1][j - input[i - 1]];
				}
			}
		}
		return subsetCount[input.length][sum];
	}

}
