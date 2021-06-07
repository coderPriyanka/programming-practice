package com.gfg.dp.knapsack;

import java.util.Scanner;

public class EqualSumPartition {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		System.out.println(findEqualSumPartition(input));
		in.close();
	}

	private static int findEqualSumPartition(int[] input) {
		int sum = 0;
		for (int i = 0; i < input.length; i++) {
			sum += input[i];
		}
		if (sum % 2 != 0) {
			return 0;
		}
		sum = sum >> 2;
		int[][] equalPartition = new int[input.length + 1][sum + 1];
		for (int j = 0; j <= sum; j++) {
			equalPartition[0][j] = 0;
		}
		for (int i = 0; i <= input.length; i++) {
			equalPartition[i][0] = 1;
		}
		for (int i = 1; i <= input.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (input[i - 1] > j) {
					equalPartition[i][j] = equalPartition[i - 1][j];
				} else {
					equalPartition[i][j] = equalPartition[i - 1][j] | equalPartition[i - 1][j - input[i - 1]];
				}
			}
		}
		return equalPartition[input.length][sum];
	}

}
