package com.gfg.dp.knapsack;

import java.util.Scanner;

public class NumberOfSubsetWithGivenDifference {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int diff = in.nextInt();
		System.out.println(countSubsets(arr, n, diff));
		in.close();
	}

	private static int countSubsets(int[] arr, int n, int diff) {
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
		}
		return countSubsetSum(arr, n, (sum + diff) / 2);
	}

	private static int countSubsetSum(int[] arr, int n, int sum) {
		int[][] subsets = new int[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			subsets[i][0] = 1;
		}
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (arr[i - 1] <= j) {
					subsets[i][j] = subsets[i - 1][j - arr[i - 1]] + subsets[i - 1][j];
				} else {
					subsets[i][j] = subsets[i - 1][j];
				}
			}
		}
		return subsets[n][sum];
	}

}
