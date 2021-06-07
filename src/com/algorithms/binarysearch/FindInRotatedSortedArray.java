package com.algorithms.binarysearch;

import java.util.Scanner;

public class FindInRotatedSortedArray {

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
	
	public static int search(int[] arr, int target) {
        int start = 0, end = arr.length - 1, pivotIndex;
		if (arr[start] <= arr[end]) {
			pivotIndex = 0;
		}
		else {
            pivotIndex = findPivot(arr, arr.length, start, end);
        }
        int index = binarySearch(arr, start, pivotIndex - 1, target);
        if (index == -1) {
            index = binarySearch(arr, pivotIndex, end, target);
        }
		return index;
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
    private static int binarySearch(int[] arr, int start, int end, int element) {
        if (start > end) {
            return -1;
        }
        if (start == end) {
            return element == arr[start] ? start : -1;
        }
        int mid = start + (end - start) / 2;
        if (arr[mid] == element) {
            return mid;
        }
        if (element < arr[mid]) {
            return binarySearch(arr, start, mid, element);
        }
        return binarySearch(arr, mid + 1, end, element);
    }

}
