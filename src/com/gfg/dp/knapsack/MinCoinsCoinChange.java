package com.gfg.dp.knapsack;

import java.util.Scanner;

public class MinCoinsCoinChange {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = in.nextInt();
		}
		int sum = in.nextInt();
		System.out.println(minimumNumberOfWays(coins, sum));
		in.close();
	}

	private static int minimumNumberOfWays(int[] coins, int sum) {
		int maxValue = Integer.MAX_VALUE - 1;
		int[][] minCoins = new int[coins.length + 1][sum + 1];
		for (int j = 0; j <= sum; j++) {
			minCoins[0][j] = maxValue;
		}
		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coins[i - 1] > j) {
					minCoins[i][j] = minCoins[i - 1][j];
				} else {
					minCoins[i][j] = Math.min(minCoins[i - 1][j], minCoins[i][j - coins[i - 1]] + 1);
				}
			}
		}
		return minCoins[coins.length][sum] == maxValue ? - 1 : minCoins[coins.length][sum];
	}
}
