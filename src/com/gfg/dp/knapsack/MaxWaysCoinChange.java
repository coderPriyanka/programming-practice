package com.gfg.dp.knapsack;

import java.util.Scanner;

public class MaxWaysCoinChange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = in.nextInt();
		}
		int sum = in.nextInt();
		System.out.println(maximumNumberOfWays(coins, sum));
		in.close();
	}

	private static int maximumNumberOfWays(int[] coins, int sum) {
		int[][] maxWays = new int[coins.length + 1][sum + 1];
		for (int i = 0; i <= coins.length; i++) {
			maxWays[i][0] = 1;
		}
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coins[i - 1] > j) {
					maxWays[i][j] = maxWays[i - 1][j];
				} else {
					maxWays[i][j] = maxWays[i - 1][j] + maxWays[i][j - coins[i - 1]];
				}
			}
		}
		return maxWays[coins.length][sum];
	}

}
