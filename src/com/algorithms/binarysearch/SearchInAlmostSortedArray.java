package com.algorithms.binarysearch;

import java.util.Scanner;

public class SearchInAlmostSortedArray {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int target = in.nextInt();
	    int[] arr = new int[n];
	    for (int i = 0; i < n; i++) {
	        arr[i] = in.nextInt();
	    }
        System.out.println(search(arr, target));
		in.close();
	}

	private static int search(int[] arr, int target) {
		int start = 0, end = arr.length - 1;
		return search(arr, target, start, end);
	}

	private static int search(int[] arr, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		if (start == end) {
			return target == arr[start] ? start : -1;
		}
		int mid = start + (end - start) / 2;
		if (target == arr[mid]) {
			return mid;
		}
		if (mid - 1 >= 0 && target == arr[mid - 1]) {
			return mid - 1;
		}
		if (mid + 1 < arr.length && target == arr[mid + 1]) {
			return mid + 1;
		}
		if (target < arr[mid]) {
			return search(arr, target, start, mid - 2);
		}
		return search(arr, target, mid + 2, end);
	}

}
