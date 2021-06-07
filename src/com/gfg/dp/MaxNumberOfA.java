package com.gfg.dp;

import java.util.Scanner;

public class MaxNumberOfA {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int number = in.nextInt();
		System.out.println(optimalKeys(number));
		in.close();
	}
	
	private static int optimalKeys(int n) {
        int[] maxA = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i <= 6) {
                maxA[i] = i;
            } else {
                maxA[i] = Math.max(maxA[i - 3] * 2, Math.max(maxA[i - 4] * 3, maxA[i - 5] * 4));
            }
        }
        return maxA[n];
    }
}
