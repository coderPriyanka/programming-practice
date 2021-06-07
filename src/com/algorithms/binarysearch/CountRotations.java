package com.algorithms.binarysearch;

import java.util.Scanner;

public class CountRotations {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	        arr[i] = in.nextInt();
	    }
        System.out.println(findRotations(arr));
		in.close();
	}
	private static int findRotations(int[] arr) {
		int start = 0, end = arr.length - 1;
		if (arr[start] <= arr[end]) {
			return 0;
		}
		int pivotIndex = findPivot(arr, arr.length, start, end);
		return arr.length - pivotIndex;
	}
	private static int findPivot(int[] arr, int n, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		int next = (mid + 1) % n;
		int prev = (mid - 1 + n) % n;
		if (arr[prev] <= arr[mid] && arr[mid] > arr[next]) {
			return mid + 1;
		}
		if (arr[prev] > arr[mid] && arr[mid] <= arr[next]) {
			return mid;
		}
		if (arr[start] <= arr[mid]) {
			return findPivot(arr, n, mid + 1, end);
		}
		return findPivot(arr, n, start, mid);
	}

}
