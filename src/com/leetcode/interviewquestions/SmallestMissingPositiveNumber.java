package com.leetcode.interviewquestions;

import java.util.Scanner;

public class SmallestMissingPositiveNumber {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = in.nextInt();
		}
		System.out.println(findMissingNumber(arr, n));
		in.close();
	}

	private static int findMissingNumber(int[] arr, int n) {
		int i = 0;
		while (i < n) {
			int index = arr[i] - 1;
			if (arr[i] <= 0 || arr[i] > n || arr[i] == arr[index]) {
				i++;
				continue;
			} 
			int temp = arr[i];
			arr[i] = arr[index];
			arr[index] = temp;
		}
		for (i = 0; i < n; i++) {
			if (arr[i] != i + 1) {
				return i + 1;
			}
		}
		return n + 1;
	}

}
