package com.leetcode.interviewquestions;

import java.util.Arrays;
import java.util.Scanner;

public class DivideAndSummarize {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int tests = in.nextInt();
		for (int test = 1; test <= tests; test++) {
			int n = in.nextInt();
			int[] arr = new int[n];
			int q = in.nextInt();
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			for (int Q = 1; Q <= q; Q++) {
				int sum = in.nextInt();
				boolean result = findSubsetSum(arr, n, sum);
				System.out.println(result ? "Yes" : "No");
			}
		}
		in.close();
	}

	private static boolean findSubsetSum(int[] arr, int n, int sum) {
		Arrays.sort(arr);
		int[] prefixSum = getPrefixSum(arr);
		if (prefixSum[n - 1] == sum) {
			return true;
		}
		int average = arr[0] + (arr[n - 1] - arr[0]) / 2;
		return findSubsetSum(arr, sum, 0, n - 1, average, prefixSum);
	}

	private static int[] getPrefixSum(int[] arr) {
		int[] prefixSumArray = new int[arr.length];
		int prefixSum = 0;
		for (int i = 0; i < arr.length; i++) {
			prefixSum += arr[i];
			prefixSumArray[i] = prefixSum;
		}
		return prefixSumArray;
	}
	
	private static boolean findSubsetSum(int[] arr, int sum, int low, int high, int average, int[] prefixSum) {
		if (low == high) {
			return false;
		}
		int partitionIndex = partitionAndFindIndex(arr, low, high, average);
		if (partitionIndex == -1) {
			return false;
		}
		int leftSum = prefixSum[partitionIndex];
		int rightSum = prefixSum[high] - prefixSum[partitionIndex];
		if (low > 0) {
			leftSum = leftSum - prefixSum[low - 1];
		}
		if (leftSum == sum || rightSum == sum) {
			return true;
		}
		int leftAverage = arr[low] + (arr[partitionIndex] - arr[low]) / 2;
		int rightAverage = arr[partitionIndex + 1] + (arr[high] - arr[partitionIndex + 1]) / 2;
		boolean leftResult = leftSum > sum ? findSubsetSum(arr, sum, low, partitionIndex, leftAverage, prefixSum) : false;
		boolean rightResult = rightSum > sum ? findSubsetSum(arr, sum, partitionIndex + 1, high, rightAverage, prefixSum) : false;
		return leftResult || rightResult;
	}

	private static int partitionAndFindIndex(int[] arr, int low, int high, int searchElement) {
		if (arr[low] == arr[high]) {
			return -1;
		}
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (searchElement == arr[mid]) {
				if (mid + 1 < arr.length && searchElement == arr[mid + 1]) {
					low = mid + 1;
				}
				return mid;
			}
			if (searchElement < arr[mid]) {
				if (mid - 1 >= 0 && searchElement > arr[mid - 1]) {
					return mid - 1;
				}
				high = mid;
			} else {
				if (mid + 1 < arr.length && searchElement < arr[mid + 1]) {
					return mid;
				}
				low = mid + 1;
			}
		}
		return -1;
	}
}
