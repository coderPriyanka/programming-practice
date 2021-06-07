package com.problems.google;

import java.util.Arrays;
import java.util.Scanner;

/**
 * For a given list of integers and integer K, find the number of non-empty subsets S such that min(S) + max(S) <= K.

	Example 1:
	
	nums = [2, 4, 5, 7]
	k = 8
	Output: 5
	Explanation: [2], [4], [2, 4], [2, 4, 5], [2, 5]
	Example 2:
	
	nums = [1, 4, 3, 2]
	k = 8
	Output: 15
	Explanation: 16 (2^4) - 1 (empty set) = 15
	Example 3:
	
	nums = [2, 4, 2, 5, 7]
	k = 10
	Output: 27
	Explanation: 31 (2^5 - 1) - 4 ([7], [5, 7], [4, 5, 7], [4, 7]) = 27

 * @author priyasar
 *
 */

public class NumberOfSubsets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		int k = in.nextInt();
		System.out.println(countSubsets(arr, n, k));
		in.close();
	}
	
	private static int countSubsets(int[] arr, int n, int k) {
		int sum = 0;
		Arrays.sort(arr);
		int i = 0, j = n - 1;
		while (i <= j) {
			if (arr[i] + arr[j] <= k) {
				sum += Math.pow(2, j - i);
				i++;
			} else {
				j--;
			}
		}
		return sum;
	}

}
