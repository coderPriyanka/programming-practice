package com.gfg.dp.mcm;

import java.util.Scanner;

public class MatrixChainMultiplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(findMCM(arr));
		in.close();
	}
	private static int findMCM(int[] arr) {
		int[][] mcm = new int[arr.length][arr.length];
		initialise(mcm);
		return findMCM(arr, mcm, 1, arr.length - 1);
	}
	private static void initialise(int[][] mcm) {
		for (int i = 0; i < mcm.length; i++) {
			for (int j = 0; j < mcm[i].length; j++) {
				mcm[i][j] = -1;
			}
		}
	}
	private static int findMCM(int[] arr, int[][] mcm, int i, int j) {
		if (i >= j) {
			return 0;
		}
		if (mcm[i][j] != -1) {
			return mcm[i][j];
		}
		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			int cost = findMCM(arr, mcm, i, k) + findMCM(arr, mcm, k + 1, j) + arr[i - 1] * arr[k] * arr[j];
			minCost = Math.min(cost, minCost);
		}
		mcm[i][j] = minCost;
		return minCost;
	}
}
