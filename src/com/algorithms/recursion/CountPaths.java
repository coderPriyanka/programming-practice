package com.algorithms.recursion;

import java.util.Scanner;

public class CountPaths {

	private static final int MOD = 1000000007;
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int m = in.nextInt();
		int n = in.nextInt();
		//System.out.println(numberOfPaths(m, n));
		System.out.println(numberOfPathsDP(m, n));
		in.close();
	}
	
	private static int numberOfPaths(int m, int n) {
		if (n == 1 || m == 1) {
			return 1;
		}
		return numberOfPaths(m, n - 1) + numberOfPaths(m - 1, n);
	}
	
	private static int numberOfPathsDP(int m, int n) {
		int[][] countPaths = new int[m][n];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 || j == 1) {
                    countPaths[i][j] = 1;
                } else {
                    countPaths[i][j] = (countPaths[i - 1][j] + countPaths[i] [j - 1]) % MOD;
                }
            }
        }
        return countPaths[m][n];
	}

}
