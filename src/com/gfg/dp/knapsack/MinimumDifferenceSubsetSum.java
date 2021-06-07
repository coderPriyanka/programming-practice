package com.gfg.dp.knapsack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MinimumDifferenceSubsetSum {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = in.nextInt();
		}
		System.out.println(minDifference(input, n));
		in.close();
	}

	private static int minDifference(int arr[], int n) { 
	    int sum = 0;
    	for (int i = 0; i < n; i++) {
    		sum += arr[i];
    	}
    	int[][] subsetSum = new int[n + 1][sum + 1];
    	for (int i = 0; i <= n; i++) {
    		subsetSum[i][0] = 1;
    	}
    	for (int i = 1; i <= n; i++) {
    		for (int j = 1; j <= sum; j++) {
    			if (arr[i - 1] <= j) {
    				subsetSum[i][j] = subsetSum[i - 1][j - arr[i - 1]] | subsetSum[i - 1][j];
    			} else {
    				subsetSum[i][j] = subsetSum[i - 1][j];
    			}
    		}
    	}
    	List<Integer> possibleSums = new ArrayList<>();
    	for (int j = 0; j <= sum; j++) {
    		if (subsetSum[n][j] == 1) {
    			possibleSums.add(j);
    		}
    	}
    	if (possibleSums.size() % 2 == 1) {
    		return 0;
    	}
    	int midIndex = possibleSums.size() / 2;
    	return Math.abs(possibleSums.get(midIndex - 1) - possibleSums.get(midIndex));
    }
}
