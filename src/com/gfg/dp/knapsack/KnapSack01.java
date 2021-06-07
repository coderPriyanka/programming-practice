package com.gfg.dp.knapsack;

import java.util.Scanner;

public class KnapSack01 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] weight = new int[n];
		int[] value = new int[n];
		for (int i = 0; i < n; i++) {
			weight[i] = in.nextInt();
		}
		for (int i = 0; i < n; i++) {
			value[i] = in.nextInt();
		}
		int maxWeight = in.nextInt();
		System.out.println(findMaxProfit(weight, value, maxWeight));
		in.close();
	}
	
	private static int findMaxProfit(int[] weight, int[] value, int maxWeight) {
		int[][] maxProfit = new int[weight.length  +1][maxWeight + 1];
		for (int i = 0; i <= weight.length; i++) {
			maxProfit[i][0] = 0;
		}
		for (int j = 0; j <= maxWeight + 1; j++) {
			maxProfit[0][j] = 0;
		}
		for (int i  =1; i <= weight.length; i++) {
			for (int j = 1; j <= maxWeight; j++) {
				if (weight[i - 1] > j) {
					maxProfit[i][j] = maxProfit[i - 1][j];
				} else {
					maxProfit[i][j] = Math.max(maxProfit[i-1][j], value[i - 1] + maxProfit[i - 1][j - weight[i - 1]]);
				}
			}
		}
		return maxProfit[weight.length][maxWeight];
	}

}
